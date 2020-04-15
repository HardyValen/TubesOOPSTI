import javax.swing.*;

public class Test01c_SwingAsParent extends JFrame {
    JFrame f;

    Test01c_SwingAsParent(){
        JButton b = new JButton("Submit");
        b.setBounds(100, 100, 100, 40);
        add(b);
        setSize(400, 400);

        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Test01c_SwingAsParent();
    }
}