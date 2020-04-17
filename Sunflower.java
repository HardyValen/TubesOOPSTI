
public class Sunflower extends Plant{
    public Sunflower(){
        setImage(ImageFactory.createImage(Image.PLANTS_SUNFLOWER).getImage());
        hitboxWidth = Constants.PLANTS_SUNFLOWER_WIDTH;
        hitboxHeight = Constants.PLANTS_SUNFLOWER_HEIGHT;

        maxHealth = Constants.PLANTS_SUNFLOWER_HEALTH;
        currentHealth = maxHealth;
    }

    public void setTile(Tile tile){
        this.tile = tile;
        setX(Constants.TILE_X_START + (Constants.TILE_WIDTH * (tile.posX + 1)) + (Constants.TILE_WIDTH / 2) - (Constants.PLANTS_SUNFLOWER_WIDTH / 2));
        setY(Constants.TILE_Y_START + (Constants.TILE_HEIGHT * (tile.posY + 1)) - Constants.PLANTS_SUNFLOWER_HEIGHT);
        setDX(0);
        setDY(0);
    }
}