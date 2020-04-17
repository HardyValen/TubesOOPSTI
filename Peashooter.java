import java.util.ArrayList;
import java.util.Random;

public class Peashooter extends Plant{
    public Peashooter(){
        hitboxWidth = Constants.PLANTS_PEASHOOTER_WIDTH;
        hitboxHeight = Constants.PLANTS_PEASHOOTER_HEIGHT;
        setImage(ImageFactory.createImage(Image.PLANTS_PEASHOOTER).getImage());

        maxHealth = Constants.PLANTS_PEASHOOTER_HEALTH;
        currentHealth = maxHealth;
    }

    public void setTile(Tile tile){
        this.tile = tile;
        setX(Constants.TILE_X_START + (Constants.TILE_WIDTH * (tile.posX + 1)) + (Constants.TILE_WIDTH / 2) - (Constants.PLANTS_PEASHOOTER_WIDTH / 2));
        setY(Constants.TILE_Y_START + (Constants.TILE_HEIGHT * (tile.posY + 1)) - Constants.PLANTS_PEASHOOTER_HEIGHT);
        setDX(0);
        setDY(0);

        Random rand = new Random();
        actionTime = Constants.PLANTS_PEASHOOTER_ACTIONTIME;
        actionCurrent = rand.nextInt(actionTime);;
    }

    public ArrayList<Projectile> actionShootable(){
        if (actionCurrent == 0){
            refreshActionCooldown();
            ArrayList<Projectile> buffer = new ArrayList<Projectile>();
            buffer.add(new PeaProjectile(this.tile));
            return buffer;
        } else return null;
    }
}