import java.awt.*;
import javax.swing.JButton;

public class Tile extends JButton{
    protected int posX;
    protected int posY;
    protected Plant p;

    public Tile(){
        super();
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setEnabled(false);
    }
}