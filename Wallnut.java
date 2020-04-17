
public class Wallnut extends Plant{
    public Wallnut(){
        hitboxWidth = Constants.PLANTS_WALLNUT_WIDTH;
        hitboxHeight = Constants.PLANTS_WALLNUT_HEIGHT;
        setImage(ImageFactory.createImage(Image.PLANTS_WALLNUT).getImage());
        
        maxHealth = Constants.PLANTS_WALLNUT_HEALTH;
        currentHealth = maxHealth;
    }

    public void setTile(Tile tile){
        this.tile = tile;
        setX(Constants.TILE_X_START + (Constants.TILE_WIDTH * (tile.posX + 1))  + (Constants.TILE_WIDTH / 2) - (Constants.PLANTS_WALLNUT_WIDTH / 2));
        setY(Constants.TILE_Y_START + (Constants.TILE_HEIGHT * (tile.posY + 1)) - Constants.PLANTS_WALLNUT_HEIGHT);
        setDX(0);
        setDY(0);
    }
}