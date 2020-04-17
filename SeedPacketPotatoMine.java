
public class SeedPacketPotatoMine extends SeedPacket {

    public SeedPacketPotatoMine(int i){
        super(ImageFactory.createImage(Image.SEEDPACKETS_POTATO_MINE));
        position = i;
        initialize();
    }
    
    private void initialize(){
        // Image Setter
        setImage(ImageFactory.createImage(Image.SEEDPACKETS_POTATO_MINE).getImage());

        // Dimension
        int y = Constants.SEEDPACKET_Y_START + (Constants.SEEDPACKET_HEIGHT * position);
        setBounds(Constants.SEEDPACKET_X_START, y, Constants.SEEDPACKET_WIDTH, Constants.SEEDPACKET_HEIGHT);

        // Set Cooldown
        cdTime = Constants.SEEDPACKET_POTATO_MINE_COOLDOWN;
        cdCurrent = cdTime;

        // SP Cost
        cost = Constants.PLANTS_POTATO_MINE_COST;
    }
    
    public Plant getPlant(){
        return new PotatoMine();
    }
}