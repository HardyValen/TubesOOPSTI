
public class Repeater extends Plant{
    public Repeater(){
        setImage(ImageFactory.createImage(Image.PLANTS_REPEATER).getImage());
    }

    public void setTile(Tile tile){
        this.tile = tile;
        setX(Constants.TILE_X_START + (Constants.TILE_WIDTH * tile.posX) + (Constants.TILE_WIDTH / 2) - (Constants.PLANTS_REPEATER_WIDTH / 2));
        setY(Constants.TILE_Y_START + (Constants.TILE_HEIGHT * tile.posY) - Constants.PLANTS_REPEATER_HEIGHT);
        setDX(0);
        setDY(0);
    }
}