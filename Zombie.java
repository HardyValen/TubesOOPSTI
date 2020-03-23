public abstract class Zombie extends Entity implements Printable, Damageable{
    protected int maxHealth;
    protected int currentHealth;
    protected int spawnedTurn;
    protected int movementTime;
    protected int damage;

    public Zombie(
        int maxHealth,
        int spawnedTurn,
        int movementTime,
        int representation,
        int damage,
        String name
    ){
        super(representation);
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.spawnedTurn = spawnedTurn;
        this.movementTime = movementTime;
        this.damage = damage;
        this.name = name;
    }

    /**
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * @return the currentHealth
     */
    public int getCurrentHealth() {
        return currentHealth;
    }

    /**
     * @return the maxHealth
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * @return the movementTime
     */
    public int getMovementTime() {
        return movementTime;
    }

    /**
     * @return the spawnedTurn
     */
    public int getSpawnedTurn() {
        return spawnedTurn;
    }

    /**
     * @param damage the damage to set
     */
    public void setDamage(int damage) {
        this.damage = damage;
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
     * @param movementTime the movementTime to set
     */
    public void setMovementTime(int movementTime) {
        this.movementTime = movementTime;
    }

    /**
     * @param spawnedTurn the spawnedTurn to set
     */
    public void setSpawnedTurn(int spawnedTurn) {
        this.spawnedTurn = spawnedTurn;
    }

    public void damageByAmount(int amount) {
        this.currentHealth -= amount;
    }

    public void print(){
        System.out.println("Zombie Name: " + this.getName() + " " + this.getRepresentation());
        System.out.println("Zombie Stats:");
        System.out.println("\tMax Health: " + this.getMaxHealth());
        System.out.println("\tCurrent Health: " + this.getCurrentHealth());
        System.out.println("\tMovement Time: " + this.getMovementTime());
        System.out.println("\tSpawned At Turn: " + this.getSpawnedTurn());
    }
}