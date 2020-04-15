import java.awt.event.*;
import javax.swing.*;

public class Test02_JButtonActionListener {
    public static void main(String[] args) {
        JFrame f = new JFrame("Plant vs Zombies: Bootleg");
        JTextField tf = new JTextField();

        tf.setBounds(50, 50, 150, 20);
        JButton b = new JButton("Submit");
        b.setBounds(50, 100, 95, 30);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText("Welcome to Plant vs Zombies: Bootleg");
            }
        });

        f.add(b);
        f.add(tf);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Supaya kaga running di background sewaktu windownya diclosed.
    }
}