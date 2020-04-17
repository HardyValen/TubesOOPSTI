import java.util.ArrayList;

public class Repeater extends Plant{
    protected int actionDelay;
    protected int actionDelayCurrent;

    public Repeater(){
        hitboxWidth = Constants.PLANTS_REPEATER_WIDTH;
        hitboxHeight = Constants.PLANTS_REPEATER_HEIGHT;
        setImage(ImageFactory.createImage(Image.PLANTS_REPEATER).getImage());

        maxHealth = Constants.PLANTS_REPEATER_HEALTH;
        currentHealth = maxHealth;
    }

    public void setTile(Tile tile){
        this.tile = tile;
        setX(Constants.TILE_X_START + (Constants.TILE_WIDTH * (tile.posX + 1)) + (Constants.TILE_WIDTH / 2) - (Constants.PLANTS_REPEATER_WIDTH / 2));
        setY(Constants.TILE_Y_START + (Constants.TILE_HEIGHT * (tile.posY + 1)) - Constants.PLANTS_REPEATER_HEIGHT);
        setDX(0);
        setDY(0);

        actionTime = Constants.PLANTS_REPEATER_ACTIONTIME;
        actionCurrent = actionTime;

        actionDelay = Constants.PLANTS_REPEATER_ACTIONDELAY;
        actionDelayCurrent = actionDelay;
    }

    public ArrayList<Projectile> actionShootable(){
        if (actionCurrent <= 0){
            if (actionDelayCurrent <= 0) {
                refreshActionCooldown();
                actionDelayCurrent = actionDelay;

                ArrayList<Projectile> buffer = new ArrayList<Projectile>();
                buffer.add(new PeaProjectile(this.tile));
                return buffer;
            } else if (actionDelayCurrent == actionDelay) {
                actionDelayCurrent--;

                ArrayList<Projectile> buffer = new ArrayList<Projectile>();
                buffer.add(new PeaProjectile(this.tile));
                return buffer;
            } else {
                actionDelayCurrent--;
                return null;
            }
        } else {
            return null;
        }
    }
}