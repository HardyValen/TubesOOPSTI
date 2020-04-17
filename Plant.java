import java.util.ArrayList;

public abstract class Plant extends Entity implements Damageable{
    protected int maxHealth;
    protected int currentHealth;
    protected int actionTime;
    protected int actionCurrent;

    protected Tile tile;

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void damageByAmount(int a) {
        currentHealth -= a;   
    }


    public void setTile(Tile tile){}

    public void refreshActionCooldown(){
        actionCurrent = actionTime;
    }

    public ArrayList<Projectile> actionShootable(){return null;}  // To be written in ? extends Plant.
}