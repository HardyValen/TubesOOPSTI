import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;

public class GamePanel extends JPanel{
    public static int frame = 0;
    public static int turn = 0;
    private ImageIcon backgroundImage;
    private ImageIcon gameOverImage;
    private Timer timer;
    private ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    private ArrayList<SeedPacket> seedPackets = new ArrayList<SeedPacket>();
    private boolean isInGame = true;
    private String state = "Game";
    
    public GamePanel(){
        initializeVariables();
        initializeLayout();
        initialializeSeedPackets();
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

    private void drawZombies(Graphics g){
        for (Zombie zombie : zombies) {
            g.drawImage(zombie.getImage(), zombie.getX(), zombie.getY(), this);
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
            drawZombies(g);
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

        // zombieCheckAll();
        // checkGame();
        spawnZombie();
        for (SeedPacket seedPacket : seedPackets) {
            seedPacket.updateSeedPacket();
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

    private boolean isStartOfTurn(){
        return GamePanel.frame % Constants.GAME_TURN_MOD == 0;
    }

    private void zombieCheckAll(){
        int i = 0;

        if (isStartOfTurn()){
            for (Zombie zombie : zombies) {
                System.out.println(zombie.getClass().getSimpleName() + " " + zombie.getCurrentHealth());
            }
        }

        while (zombies.size() > 0 && i < zombies.size()) {
            if (!this.zombieCheckHP(i)) {
                i++;
            }
        }

        if (isStartOfTurn()){
            for (Zombie zombie : zombies) {
                System.out.print(zombie.getClass().getSimpleName() + ", ");
            }
            System.out.println(" ");
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
            if (zombies.get(0).getX() < Constants.TILE_X_START) {
                zombies.clear();
                isInGame = false;
                state = "Game Over";
            }
        }
    }

    private void initialializeSeedPackets(){
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
            add(seedPacket);
        }
    }
}