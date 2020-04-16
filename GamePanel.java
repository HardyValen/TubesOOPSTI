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
        sp = 50;

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

        for (Zombie zombie : zombies) {
            zombie.move();
        }

        zombieCheckAll();
        // checkGame();     // GameOverCondition
        // spawnZombie();
        spawnSun();         
        sunControl();       // Controls the sun whose offset
        checkPlants();

        // Update Seed Packet
        for (SeedPacket seedPacket : seedPackets) {
            seedPacket.updateSeedPacket();
        }

        // Update Sun Movement
        for (Sun sun : sunIcons) {
            sun.move();
        }
    }

    private void spawnZombie(){
        if (GamePanel.turn % 2 == 1 && isStartOfTurn()) {
            zombies.add(ZombieFactory.createZombie(ZombieKey.ZOMBIES_NORMAL));
        }

        if (GamePanel.turn % 3 == 2 && isStartOfTurn()) {
            zombies.add(ZombieFactory.createZombie(ZombieKey.ZOMBIES_CONEHEAD));
        }

        if (GamePanel.turn % 5 == 1 && isStartOfTurn()) {
            zombies.add(ZombieFactory.createZombie(ZombieKey.ZOMBIES_BUCKETHEAD));
        }

        if (GamePanel.turn % 7 == 1 && isStartOfTurn()) {
            zombies.add(ZombieFactory.createZombie(ZombieKey.ZOMBIES_BRICKHEAD));
        }

        if (GamePanel.turn % 10 == 1 && isStartOfTurn()) {
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

        // Debug
        // if (isStartOfTurn()){
        //     for (Zombie zombie : zombies) {
        //         System.out.println(zombie.getClass().getSimpleName() + " " + zombie.getCurrentHealth());
        //     }
        // }

        while (zombies.size() > 0 && i < zombies.size()) {
            if (!this.zombieCheckHP(i)) {
                i++;
            }
        }

        int counter = 0;
        for (Sun sun : sunIcons) {
            System.out.println("Sun " + counter + ": " + sun.x + " " + sun.y);
            counter++;
        }

        System.out.println(" ");

        // Debug
        // if (isStartOfTurn()){
        //     for (Zombie zombie : zombies) {
        //         System.out.print(zombie.getClass().getSimpleName() + ", ");
        //     }
        //     System.out.println(" ");
        // }
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
            if (zombies.get(0).getX() < Constants.TILE_X_START) {
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

    private void sunControl(){
        int count = 0;
        while (count < sunIcons.size()){
            Sun sun = sunIcons.get(count);
            if (sun.getY() > Constants.BOARD_HEIGHT) {
                sunIcons.remove(sun);
                remove(sun);
            }
            count++;
        }
    }
}