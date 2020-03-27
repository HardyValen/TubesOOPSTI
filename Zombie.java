public abstract class Zombie extends Entity implements Damageable, Movable, Damaging{
    // Zombie Variables
    protected int attackDamage;
    protected final int spawnedTurn;

    // Damageable Variables
    protected int maxHealth;
    protected int currentHealth;

    // Movable Variables
    protected int direction; // (Kanan ke Kiri)

    public Zombie(
        int spawnedTurn,
        int maxHealth,
        int direction,
        int representation,
        String name,
        int actionTime,
        int attackDamage,
        Tile tile
    ){
        super(representation, name, actionTime, tile);
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.spawnedTurn = spawnedTurn;
        this.direction = direction;
    }

    /**
     * @return the currentHealth
     */
    public int getCurrentHealth() {
        return currentHealth;
    }

    /**
     * @return the direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     * @return the maxHealth
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * @return the spawnedTurn
     */
    public int getSpawnedTurn() {
        return spawnedTurn;
    }

    /**
     * @param currentHealth the currentHealth to set
     */
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    /**
     * @param maxHealth the maxHealth to set
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void refreshHealth() {
        this.setCurrentHealth(this.getMaxHealth());
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void damageByAmount(int a) {
        this.setCurrentHealth(this.getCurrentHealth() - a);
        
    }

    public void print(){
        System.out.println("Zombie Stats:");
        System.out.println("Max Health: " + this.getMaxHealth());
        System.out.println("Current Health: " + this.getCurrentHealth());
        System.out.println("Direction " + this.getDirection());
        System.out.println("Spawned on turn: " + this.getSpawnedTurn());
        System.out.println("");
    }
}