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

    public ArrayList<Projectile> actionShootable(){return null;}  // To be written in peashooter family
    public Sun actionGenerate(){return null;} // To be written in sun family
    public int actionExplode(){return -1;}   // To be written in explosive plants

    // Explode state:
    // -1 = non explosive plant
    // 0 = explosive plant not exploded yet
    // 1 = explosive plant exploded, damaging everything in the radius
    // 2 = explosive plant aftermath and will be removed if action time is 0
}