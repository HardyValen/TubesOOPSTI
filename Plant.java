
public abstract class Plant extends Entity implements Damageable{
    protected int maxHealth;
    protected int currentHealth;

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void damageByAmount(int a) {
        currentHealth -= a;   
    }
}