import java.util.ArrayList;
import java.util.Random;

public class Threepeater extends Plant{
    public Threepeater(){
        setImage(ImageFactory.createImage(Image.PLANTS_THREEPEATER).getImage());
        hitboxWidth = Constants.PLANTS_THREEPEATER_WIDTH;
        hitboxHeight = Constants.PLANTS_THREEPEATER_HEIGHT;

        maxHealth = Constants.PLANTS_THREEPEATER_HEALTH;
        currentHealth = maxHealth;
    }

    public void setTile(Tile tile){
        this.tile = tile;
        setX(Constants.TILE_X_START + (Constants.TILE_WIDTH * (tile.posX + 1))  + (Constants.TILE_WIDTH / 2) - (Constants.PLANTS_THREEPEATER_WIDTH / 2));
        setY(Constants.TILE_Y_START + (Constants.TILE_HEIGHT * (tile.posY + 1)) - Constants.PLANTS_THREEPEATER_HEIGHT);
        setDX(0);
        setDY(0);
        
        Random rand = new Random();
        actionTime = Constants.PLANTS_THREEPEATER_ACTIONTIME;
        actionCurrent = rand.nextInt(actionTime);;
    }

    public ArrayList<Projectile> actionShootable(){
        if (actionCurrent == 0){
            refreshActionCooldown();

            ArrayList<Projectile> buffer = new ArrayList<Projectile>();
            buffer.add(new PeaProjectile(tile));
            
            int getAbove = tile.posY - 1;
            int getBelow = tile.posY + 1;

            if (getAbove >= 0) {
                Tile tb = tile.row.grid.rows.get(getAbove).tiles.get(tile.posX);
                buffer.add(new PeaProjectile(tb));
            }

            if (getBelow < tile.row.grid.rowSize) {
                Tile tb = tile.row.grid.rows.get(getBelow).tiles.get(tile.posX);
                buffer.add(new PeaProjectile(tb));
            }
            
            return buffer;
        } else return null;
    }
}