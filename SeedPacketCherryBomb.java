import javax.swing.JButton;

public class SeedPacketCherryBomb extends SeedPacket {

    public SeedPacketCherryBomb(int i){
        super(ImageFactory.createImage(Image.SEEDPACKETS_CHERRY_BOMB));
        position = i;
        initialize();
    }
    
    private void initialize(){
        // Image Setter
        setImage(ImageFactory.createImage(Image.SEEDPACKETS_CHERRY_BOMB).getImage());

        // Dimension
        int y = Constants.SEEDPACKET_Y_START + (Constants.SEEDPACKET_HEIGHT * position);
        setBounds(Constants.SEEDPACKET_X_START, y, 100, 50);
        
        // Set Cooldown
        cdTime = 20 * Constants.GAME_TURN_MOD;
        cdCurrent = cdTime;
    }
}