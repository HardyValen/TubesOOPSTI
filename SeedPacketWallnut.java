public class SeedPacketWallnut extends SeedPacket {

    public SeedPacketWallnut(int i){
        super(ImageFactory.createImage(Image.SEEDPACKETS_WALLNUT));
        position = i;
        initialize();
    }
    
    private void initialize(){
        // Image Setter
        setImage(ImageFactory.createImage(Image.SEEDPACKETS_WALLNUT).getImage());
        
        // Dimension
        int y = Constants.SEEDPACKET_Y_START + (Constants.SEEDPACKET_HEIGHT * position);
        setBounds(Constants.SEEDPACKET_X_START, y, Constants.SEEDPACKET_WIDTH, Constants.SEEDPACKET_HEIGHT);

        // Set Cooldown
        cdTime = Constants.SEEDPACKET_WALLNUT_COOLDOWN;
        cdCurrent = cdTime;

        // Set Cost
        cost = Constants.PLANTS_WALLNUT_COST;
    }

    public Plant getPlant(){
        return new Wallnut();
    }
}