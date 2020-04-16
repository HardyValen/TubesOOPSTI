public class SeedPacketSunflower extends SeedPacket {

    public SeedPacketSunflower(int i){
        super(ImageFactory.createImage(Image.SEEDPACKETS_SUNFLOWER));
        position = i;
        initialize();
    }
    
    private void initialize(){
        // Image Setter
        setImage(ImageFactory.createImage(Image.SEEDPACKETS_SUNFLOWER).getImage());
        
        // Dimension
        int y = Constants.SEEDPACKET_Y_START + (Constants.SEEDPACKET_HEIGHT * position);
        setBounds(Constants.SEEDPACKET_X_START, y, Constants.SEEDPACKET_WIDTH, Constants.SEEDPACKET_HEIGHT);

        // Set Cooldown
        cdTime = 5 * Constants.GAME_TURN_MOD;
        cdCurrent = 0;

        // Set Cost
        cost = Constants.PLANTS_SUNFLOWER_COST;
    }

    public Plant getPlant(){
        return new Sunflower();
    }
}