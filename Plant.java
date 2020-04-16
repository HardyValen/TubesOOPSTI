
public abstract class Plant extends Entity implements Damageable{
    protected int maxHealth;
    protected int currentHealth;
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
}