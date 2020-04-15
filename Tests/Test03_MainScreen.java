import javax.swing.*;

public class Test03_MainScreen {
    JFrame f;
    public final static int gameWidth = 1024;
    public final static int gameHeight = 576;
    
    Test03_MainScreen(){
        f = new JFrame("Plants vs Zombies: Bootleg Edition");
        JButton buttonPlayGame = new JButton(new ImageIcon("assets/ButtonPlayGame.png"));
        JLabel mainScreenBg = new JLabel(new ImageIcon("assets/MainScreen.png"));

        buttonPlayGame.setBounds(387, 396, 250, 60);
        mainScreenBg.setBounds(0, 0, gameWidth, gameHeight);
        f.add(buttonPlayGame);
        f.add(mainScreenBg);

        f.setSize(gameWidth, gameHeight + 32);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {  
        new Test03_MainScreen();
    }
}