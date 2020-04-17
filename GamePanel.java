import javax.swing.JTextField;
import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.*;

public class GamePanel extends JLayeredPane{
    public static int frame = 0;
    public static int turn = 0;
    private ImageIcon backgroundImage;
    private ImageIcon gameOverImage;
    private Timer timer;
    private ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    private ArrayList<SeedPacket> seedPackets = new ArrayList<SeedPacket>();
    private ArrayList<Sun> sunIcons = new ArrayList<Sun>();
    private ArrayList<Projectile> projectiles = new ArrayList<Projectile>(); 
    private boolean isInGame = true;
    private String state = "Game";
    private Grid grid;
    public static int sp;     // Sunflower Points
    private JTextField spCounter;
    private JLabel spIcon;
    private static boolean plantState = false;
    private static Plant seedPacketPlant;
    private SeedPacket seedPacketBuffer = null;
    private int clickBuffer = 0;    // For Cancelling Plant
    
    public GamePanel(){
        initializeVariables();
        initializeLayout();
        initializeSP();
        initializeSeedPackets();
        initializeGrid();
    }

    private void initializeVariables(){
        this.backgroundImage = ImageFactory.createImage(Image.ENVIRONMENT_GAME_SCREEN);
        this.gameOverImage = ImageFactory.createImage(Image.ENVIRONMENT_GAMEOVER);
        this.timer = new Timer(Constants.GAME_SPEED, new GameLoop(this));
        this.timer.start();
    }

    private void initializeLayout(){
        setPreferredSize(new Dimension(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT));
    }

    private void initializeSP(){
        // Initialize SP
        sp = Constants.STARTING_SUN;

        // SP counter
        setLayout(null);
        spIcon = new JLabel(ImageFactory.createImage(Image.ENVIRONMENT_SUN_ICON));
        spIcon.setBounds(
            Constants.ENVIRONMENT_SUN_ICON_X_START, 
            Constants.ENVIRONMENT_SUN_ICON_Y_START, 
            Constants.ENVIRONMENT_SUN_ICON_WIDTH, 
            Constants.ENVIRONMENT_SUN_ICON_HEIGHT
        );
        
        spCounter = new JTextField(String.valueOf(sp));
        spCounter.setBounds(
            90,
            33,
            60,
            30
        );

        spCounter.setEnabled(false);
        spCounter.setDisabledTextColor(Color.BLACK);
        add(spIcon);
        add(spCounter);
    }

    private void initializeSeedPackets(){
        setLayout(null);
        seedPackets.add(new SeedPacketPeashooter(0));
        seedPackets.add(new SeedPacketRepeater(1));
        seedPackets.add(new SeedPacketThreepeater(2));
        seedPackets.add(new SeedPacketSunflower(3));
        seedPackets.add(new SeedPacketWallnut(4));
        seedPackets.add(new SeedPacketSpikeweed(5));
        seedPackets.add(new SeedPacketPotatoMine(6));
        seedPackets.add(new SeedPacketCherryBomb(7));

        for (SeedPacket seedPacket : seedPackets) {
            seedPacket.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    clickBuffer++;

                    if (GamePanel.sp >= seedPacket.cost){
                        grid.setEnableAll(true);
                        GamePanel.plantState = true;
                        seedPacketPlant = seedPacket.getPlant();
                        seedPacketBuffer = seedPacket;
                    }

                    // Cancel if seed packet is clicked again
                    if (clickBuffer == 2){
                        grid.setEnableAll(false);
                        GamePanel.plantState = false;
                        clickBuffer = 0;
                    }
                }
            });

            add(seedPacket);
        }
    }

    private void initializeGrid(){
        setLayout(null);
        grid = new Grid(5, 9);

        for(Row row : grid.rows){
            for (Tile tile : row.tiles){
                tile.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent arg0) {
                        if (GamePanel.plantState && tile.hasPlant()){
                            System.out.println(seedPacketPlant.currentHealth);
                            seedPacketPlant.setTile(tile);
                            tile.plant = GamePanel.seedPacketPlant;
                            grid.setEnableAll(false);
                            GamePanel.plantState = false;
                            GamePanel.sp -= seedPacketBuffer.cost;
                            spCounter.setText(String.valueOf(sp));
                            seedPacketBuffer.refreshCooldown();
                            clickBuffer = 0;
                        }
                    }
                });
                add(tile);
            }
        }
    }

    private void drawEntities(Graphics g){
        for (Zombie zombie : zombies) {
            g.drawImage(zombie.getImage(), zombie.getX(), zombie.getY(), this);
        }

        for (Projectile projectile : projectiles){
            g.drawImage(projectile.getImage(), projectile.getX(), projectile.getY(), this);
        }

        for (Row row : grid.rows){
            for (Tile tile : row.tiles){
                if (tile.plant != null){
                    g.drawImage(tile.plant.getImage(), tile.plant.getX(), tile.plant.getY(), this);
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage.getImage(), 0, 0, null);
        doDrawing(g);
    }

    private void doDrawing(Graphics g){
        if (isInGame){
            drawEntities(g);
        } else {
            if (state.equals("Game Over")) {
                g.drawImage(gameOverImage.getImage(), 0, 0, null);
            }
            if (timer.isRunning()){ 
                timer.stop();
                GamePanel.frame = 0;
                GamePanel.turn = 0;
            }
        }

        Toolkit.getDefaultToolkit().sync(); // Biar kaga pecah-pecah animasinya
    }

    public void doOneLoop(){
        update();
        repaint();
    }

    private void update(){
        GamePanel.frame++;
        if (isStartOfTurn() && GamePanel.frame != 0) {
            GamePanel.turn++;
        }

        checkCollision();
        checkGame();     // GameOverCondition
        spawnZombie();
        spawnSun();         
        entityControl();       // Controls the sun and projectile whose offset and zombies, plants too
        checkPlants();      // Grid Checker
        updatePlants();
        spawnProjectiles();

        // Update Seed Packet
        for (SeedPacket seedPacket : seedPackets) {
            seedPacket.updateSeedPacket();
        }

        // Update Sun Movement
        for (Sun sun : sunIcons) {
            sun.move();
        }

        // Update Projectile Movement
        for (Projectile projectile: projectiles) {
            projectile.move();
        }
    }

    private void checkCollision(){
        for (Projectile projectile : projectiles) {
            int projectileX = projectile.getX();
            int projectileY = projectile.getY();

            for(Zombie zombie : zombies){
                int zombieX = zombie.hitboxX;
                int zombieY = zombie.hitboxY;

                if (
                    projectileX >= zombieX &&
                    projectileX <= (zombieX + zombie.hitboxWidth) &&
                    projectileY >= zombieY &&
                    projectileY <= (zombieY + zombie.hitboxHeight)
                ) {
                    zombie.damageByAmount(projectile.attackDamage);
                    projectile.setIsDead(true);
                }
            }
        }

        for(Zombie zombie : zombies){
            int zombieX = zombie.hitboxX;
            int zombieY = zombie.hitboxY;

            ArrayList<Plant> plantBuffer = new ArrayList<Plant>();
            
            for(Row row : grid.rows){
                for(Tile tile : row.tiles){
                    if (tile.plant != null){
                        plantBuffer.add(tile.plant);
                    }
                }
            }

            int i = 0;
            boolean moveFlag = true;
            Plant selectedPlant = null;
            while(i < plantBuffer.size() && moveFlag){
                int plantX = plantBuffer.get(i).getX();
                int plantY = plantBuffer.get(i).getY();
                if (
                    plantX >= zombieX &&
                    plantX <= (zombieX + zombie.hitboxWidth) &&
                    plantY >= zombieY &&
                    plantY <= (zombieY + zombie.hitboxHeight)
                ) {
                    moveFlag = false;
                    selectedPlant = plantBuffer.get(i);
                }
                i++;
            }
            
            if (!moveFlag) {
                if (!selectedPlant.phaseable) {
                    if (zombie.attackDelayCurrent <= 0) {
                        selectedPlant.damageByAmount(zombie.getAttackDamage());
                        zombie.refreshAttack();
                        System.out.println(selectedPlant.currentHealth);

                        if (selectedPlant.getCurrentHealth() <= 0) {
                            selectedPlant.setIsDead(true);
                        }
                    } else {
                        if (zombie.attackDelayCurrent > 0) {
                            zombie.attackDelayCurrent--;
                        }
                    }
                } else {
                    if (zombie.attackDelayCurrent > 0) {
                        zombie.attackDelayCurrent--;
                    } else {
                        zombie.move();
                    }
                }
            } else {
                if (zombie.attackDelayCurrent > 0) {
                    zombie.attackDelayCurrent--;
                } else {
                    zombie.move();
                }
            }

        }
    }

    private void spawnZombie(){
        if (GamePanel.turn % 10 == 0 && isStartOfTurn() && GamePanel.turn >= 7) {
            zombies.add(ZombieFactory.createZombie(ZombieKey.ZOMBIES_NORMAL));
        }

        if (GamePanel.turn % 13 == 0 && isStartOfTurn() && GamePanel.turn >= 12) {
            zombies.add(ZombieFactory.createZombie(ZombieKey.ZOMBIES_CONEHEAD));
        }

        if (GamePanel.turn % 14 == 0 && isStartOfTurn() && GamePanel.turn >= 16) {
            zombies.add(ZombieFactory.createZombie(ZombieKey.ZOMBIES_BUCKETHEAD));
        }

        if (GamePanel.turn % 15 == 0 && isStartOfTurn() && GamePanel.turn >= 24) {
            zombies.add(ZombieFactory.createZombie(ZombieKey.ZOMBIES_BRICKHEAD));
        }

        if (GamePanel.turn % 20 == 0 && isStartOfTurn() && GamePanel.turn >= 30) {
            zombies.add(ZombieFactory.createZombie(ZombieKey.ZOMBIES_GARGANTUAR));
        }
    }

    private void spawnSun(){
        if (GamePanel.turn % 2 == 1 && isStartOfTurn()){
            Random rand = new Random();
            int gridWidth = rand.nextInt(grid.rows.get(0).tiles.size()) * Constants.TILE_WIDTH;
            int spawnArea = Constants.TILE_X_START + Constants.TILE_WIDTH + gridWidth;
            Sun sun = new Sun(spawnArea, -Constants.ENVIRONMENT_SUN_LAWN_HEIGHT);
            
            // Gives sun the appropriate action listener
            sun.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    sp += 50;
                    sunIcons.remove(sun);
                    remove(sun);
                    spCounter.setText(String.valueOf(sp));
                }
            });
            
            // Adding sun to panel
            sunIcons.add(sun);
            add(sun, Constants.DEPTH_SUN);
        }
    }

    private boolean isStartOfTurn(){
        return GamePanel.frame % Constants.GAME_TURN_MOD == 0;
    }

    private void zombieCheckAll(){
        int i = 0;
        while (zombies.size() > 0 && i < zombies.size()) {
            if (!this.zombieCheckHP(i)) {
                i++;
            }
        }
    }

    private boolean zombieCheckHP(int i){
        if (i < zombies.size()){
            if (zombies.get(i).getCurrentHealth() <= 0) {
                zombies.remove(i);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private void checkGame(){
        if (zombies.size() > 0) {
            if (zombies.get(0).getX() < Constants.TILE_X_START + 50) {
                zombies.clear();

                // Clear Seed Packets
                for (SeedPacket seedPacket : seedPackets) {
                    remove(seedPacket);
                }

                // Remove Tiles
                for (Row row : grid.rows) {
                    for (Tile tile : row.tiles){
                        remove(tile);
                    }
                }

                // Remove SP Counter and Lawn Sun
                remove(spCounter);
                remove(spIcon);
                for (Sun sun : sunIcons) {
                    remove(sun);
                }

                isInGame = false;
                state = "Game Over";
            }
        }
    }

    private void checkPlants(){
        for (Row row : grid.rows) {
            for (Tile tile : row.tiles){
                tile.checkPlant();
            }
        }
    }

    private void entityControl(){
        // Sun Control
        int count = 0;
        while (count < sunIcons.size()){
            Sun sun = sunIcons.get(count);
            if (sun.getY() > Constants.BOARD_HEIGHT) {
                sunIcons.remove(sun);
                remove(sun);
            }
            count++;
        }

        // Projectile Control
        count = 0;
        while (count < projectiles.size()){
            Projectile p = projectiles.get(count);
            if (p.getX() > Constants.BOARD_WIDTH || p.isDead()) {
                projectiles.remove(p);
            }
            count++;
        }

        // Legacy Zombie Control
        zombieCheckAll();

        // Plant Control
        for(Row row : grid.rows){
            for (Tile tile : row.tiles){
                if (tile.plant != null) {
                    if (tile.plant.isDead()){
                        tile.plant = null;
                    }
                }
            }
        }
    }

    private void spawnProjectiles(){
        for (Row row : grid.rows) {
            for (Tile tile : row.tiles){
                if (tile.plant != null) {
                    ArrayList<Projectile> buffer = tile.plant.actionShootable();
                    if (buffer != null) {
                        projectiles.addAll(buffer);
                    }
                }
            }
        }
    }

    private void updatePlants(){
        for (Row row : grid.rows) {
            for (Tile tile : row.tiles){
                if (tile.plant != null) {
                    tile.plant.actionCurrent--;
                    System.out.println(tile.plant.actionCurrent);
                }
            }
        }
    }
}