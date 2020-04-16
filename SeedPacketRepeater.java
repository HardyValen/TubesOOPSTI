public class SeedPacketRepeater extends SeedPacket {

    public SeedPacketRepeater(int i){
        super(ImageFactory.createImage(Image.SEEDPACKETS_REPEATER));
        position = i;
        initialize();
    }
    
    private void initialize(){
        // Image Setter
        setImage(ImageFactory.createImage(Image.SEEDPACKETS_REPEATER).getImage());
        
        // Dimension
        int y = Constants.SEEDPACKET_Y_START + (Constants.SEEDPACKET_HEIGHT * position);
        setBounds(Constants.SEEDPACKET_X_START, y, 100, 50);

        // Set Cooldown
        cdTime = 5 * Constants.GAME_TURN_MOD;
        cdCurrent = cdTime;
    }
}