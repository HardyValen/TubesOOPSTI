
public class SeedPacketSpikeweed extends SeedPacket {

    public SeedPacketSpikeweed(int i){
        super(ImageFactory.createImage(Image.SEEDPACKETS_SPIKEWEED));
        position = i;
        initialize();
    }
    
    private void initialize(){
        // Image Setter
        setImage(ImageFactory.createImage(Image.SEEDPACKETS_SPIKEWEED).getImage());
        
        // Dimension
        int y = Constants.SEEDPACKET_Y_START + (Constants.SEEDPACKET_HEIGHT * position);
        setBounds(Constants.SEEDPACKET_X_START, y, Constants.SEEDPACKET_WIDTH, Constants.SEEDPACKET_HEIGHT);

        // Set Cooldown
        cdTime = Constants.SEEDPACKET_SPIKEWEED_COOLDOWN;
        cdCurrent = cdTime;

        // Set Cost
        cost = Constants.PLANTS_SPIKEWEED_COST;
    }

    public Plant getPlant(){
        return new Spikeweed();
    }
}