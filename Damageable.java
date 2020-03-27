public interface Damageable {
    // Deklarasikan maxHealth, currentHealth
    public abstract int getCurrentHealth();
    public abstract int getMaxHealth();
    public abstract void setCurrentHealth(int a);
    public abstract void damageByAmount(int a);
    public abstract void refreshHealth();
}