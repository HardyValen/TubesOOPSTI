import javax.swing.*;

public class Test01b_SwingAsConstructor {
    JFrame f;
    
    Test01b_SwingAsConstructor(){
        f = new JFrame();
        JButton playGame = new JButton(new ImageIcon("assets/ButtonPlayGame.png"));
        JLabel mainScreenBg = new JLabel(new ImageIcon("assets/MainScreen.png"));

        playGame.setBounds(387, 408, 250, 60);
        mainScreenBg.setBounds(0, 0, 1024, 576);
        f.add(playGame);
        f.add(mainScreenBg);

        f.setSize(1024, 576);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {  
        new Test01b_SwingAsConstructor();
    }
}