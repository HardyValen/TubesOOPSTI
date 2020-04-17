
public class Spikeweed extends Plant{
    public int attackDamage = Constants.SPIKEWEED_DAMAGE;

    public Spikeweed(){
        setImage(ImageFactory.createImage(Image.PLANTS_SPIKEWEED).getImage());
        hitboxWidth = Constants.TILE_WIDTH;
        hitboxHeight = Constants.TILE_HEIGHT;
        phaseable = true;

        maxHealth = Constants.PLANTS_SPIKEWEED_HEALTH;
        currentHealth = maxHealth;
    }

    public void setTile(Tile tile){
        this.tile = tile;
        setX(Constants.TILE_X_START + (Constants.TILE_WIDTH * (tile.posX + 1)) + (Constants.TILE_WIDTH / 2) - (Constants.PLANTS_SPIKEWEED_WIDTH / 2));
        setY(Constants.TILE_Y_START + (Constants.TILE_HEIGHT * (tile.posY + 1)) - Constants.PLANTS_SPIKEWEED_HEIGHT);
        setDX(0);
        setDY(0);
        
        hitboxX = Constants.TILE_X_START + (Constants.TILE_WIDTH * tile.posX);
        hitboxY = Constants.TILE_Y_START + (Constants.TILE_HEIGHT * (tile.posY));
        actionTime = Constants.PLANTS_SPIKEWEED_ACTIONTIME;
        actionCurrent = actionTime;
    }

    public boolean actionSpike(){
        if (actionCurrent == 0) {
            actionCurrent = actionTime;
            return true;
        } else {
            return false;
        }
    }
}