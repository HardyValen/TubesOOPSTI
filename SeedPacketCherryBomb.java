
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
        setBounds(Constants.SEEDPACKET_X_START, y, Constants.SEEDPACKET_WIDTH, Constants.SEEDPACKET_HEIGHT);
        
        // Set Cooldown
        cdTime = Constants.SEEDPACKET_CHERRY_BOMB_COOLDOWN;
        cdCurrent = cdTime;

        // SP Cost
        cost = Constants.PLANTS_CHERRY_BOMB_COST;
    }

    public Plant getPlant(){
        return new CherryBomb();
    }
}