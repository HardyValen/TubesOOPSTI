import java.util.Random;

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

        Random rand = new Random();
        actionTime = Constants.PLANTS_SUNFLOWER_ACTIONTIME;
        actionCurrent = rand.nextInt(actionTime);
    }

    public Sun actionGenerate(){
        if (actionCurrent == 0){
            refreshActionCooldown();
            Random rand = new Random();
            int randmodX = rand.nextInt(50) - 25;
            int randmodY = rand.nextInt(50) - 25;
            int x = Constants.TILE_X_START + (Constants.TILE_WIDTH * (tile.posX + 1) + randmodX);
            int y = Constants.TILE_Y_START + (Constants.TILE_HEIGHT * tile.posY) + randmodY;
            Sun sun = new Sun(x, y);
            sun.dy = 0;
            return sun;
        } else return null;
    }
}