
public class Wallnut extends Plant{
    public Wallnut(){
        setImage(ImageFactory.createImage(Image.PLANTS_WALLNUT).getImage());
    }

    public void setTile(Tile tile){
        this.tile = tile;
        setX(Constants.TILE_X_START + (Constants.TILE_WIDTH * tile.posX)  + (Constants.TILE_WIDTH / 2) - (Constants.PLANTS_WALLNUT_WIDTH / 2));
        setY(Constants.TILE_Y_START + (Constants.TILE_HEIGHT * tile.posY) - Constants.PLANTS_WALLNUT_HEIGHT);
        setDX(0);
        setDY(0);
    }
}