import javax.swing.*;

public class GameMainFrame extends JFrame{
    public GameMainFrame() {
        initializeLayout();
    }

    private void initializeLayout(){
        add(new GamePanel());

        setTitle(Constants.TITLE);      // Title on Constants
        setIconImage(ImageFactory.createImage(Image.LOGO).getImage());
        pack();                         // To make the frame contain the game component exclusively

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);    // Center of the screen
        setResizable(false);            // Cannot Resize
        setVisible(true);

    }
}