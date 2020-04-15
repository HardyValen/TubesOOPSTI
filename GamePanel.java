import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel{
    public static int frame = 0;
    public static int turn = 0;
    private ImageIcon backgroundImage;
    private ImageIcon gameOverImage;
    private Timer timer;
    private ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    private boolean isInGame = true;
    private String state = "Game";
    
    public GamePanel(){
        initializeVariables();
        initializeLayout();
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

        zombieCheckAll();
        checkGame();
        spawnZombie();
    }

    private void spawnZombie(){
        int a = 0;

        if (GamePanel.turn % 2 == 1 && isStartOfTurn()) {
            Random rand = new Random();
            a = rand.nextInt(5) + 1;
            zombies.add(new NormalZombie(a));
        }

        if (GamePanel.turn % 3 == 2 && isStartOfTurn()) {
            Random rand = new Random();
            a = rand.nextInt(5) + 1;
            zombies.add(new ConeheadZombie(a));
        }

        if (GamePanel.turn % 5 == 1 && isStartOfTurn()) {
            Random rand = new Random();
            a = rand.nextInt(5) + 1;
            zombies.add(new BucketheadZombie(a));
        }

        if (GamePanel.turn % 7 == 1 && isStartOfTurn()) {
            Random rand = new Random();
            a = rand.nextInt(5) + 1;
            zombies.add(new BrickheadZombie(a));
        }

        if (GamePanel.turn % 10 == 1 && isStartOfTurn()) {
            Random rand = new Random();
            a = rand.nextInt(5) + 1;
            zombies.add(new Gargantuar(a));
        }
    }

    private boolean isStartOfTurn(){
        return GamePanel.frame % Constants.GAME_TURN_MOD == 0;
    }

    private void zombieCheckAll(){
        int i = 0;

        if (isStartOfTurn()){
            for (Zombie zombie : zombies) {
                zombie.damageByAmount(10);
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
            if (zombies.get(0).getX() < 297) {
                zombies.clear();
                isInGame = false;
                state = "Game Over";
            }
        }
    }
}