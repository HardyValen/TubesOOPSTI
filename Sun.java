import javax.swing.JButton;

public class Sun extends JButton {
    protected int SPValue = Constants.SUN_VALUE;
    protected int x;
    protected int y;
    protected int dx = 0;
    protected int dy = 1;

    public Sun(int x, int y){
        this.x = x;
        this.y = y;

        setBounds(
            this.x, 
            this.y, 
            Constants.ENVIRONMENT_SUN_LAWN_WIDTH, 
            Constants.ENVIRONMENT_SUN_LAWN_HEIGHT
        );

        setIcon(ImageFactory.createImage(Image.ENVIRONMENT_SUN_LAWN));
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }

    public void setDY(int dy) {
        this.dy = dy;
    }

    public void move(){
        y += dy;
        setLocation(x, y);
    }
}