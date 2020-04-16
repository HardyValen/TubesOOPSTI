import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.Image;

public abstract class SeedPacket extends JButton{
    private Image image;
    protected int position;
    protected int cdTime;
    protected int cost;
    protected int cdCurrent;

    public SeedPacket(Icon i){
        super(i);
        setContentAreaFilled(false);
        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.CENTER);
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage(){
        return image;
    }

    public void updateSeedPacket(){
        if (cdCurrent > 0) {
            setEnabled(false);
            cdCurrent--;
            setText(String.valueOf((cdCurrent / Constants.GAME_TURN_MOD) + 1));
        } else {
            if (cost > GamePanel.sp){
                setEnabled(false);
                setText("Get Sun");
            } else {
                setEnabled(true);
                setText("");
            }
        }
    }

    public void refreshCooldown(){
        this.cdCurrent = cdTime;
    }

    public abstract Plant getPlant();
}