public abstract class Plant extends Entity implements Printable, Damageable{
    protected int maxHealth;
    protected int currentHealth;
    protected int plantedTurn;
    protected int spCost;
    protected int rechargeTime;
    protected int rechargeCooldown;

    public Plant(
        int maxHealth,
        int plantedTurn,
        int spCost,
        int rechargeTime,
        String name,
        int representation
    ){
        super(representation);
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.plantedTurn = plantedTurn;
        this.spCost = spCost;
        this.rechargeTime = rechargeTime;
        Double initCooldown = Math.ceil(rechargeTime * 0.4);
        this.rechargeCooldown = initCooldown.intValue();
        this.name = name;
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
     * @return the plantedTurn
     */
    public int getPlantedTurn() {
        return plantedTurn;
    }

    /**
     * @return the rechargeTime
     */
    public int getRechargeTime() {
        return rechargeTime;
    }

    /**
     * @return the spCost
     */
    public int getSpCost() {
        return spCost;
    }

    /**
     * @return the rechargeCooldown
     */
    public int getRechargeCooldown() {
        return rechargeCooldown;
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
     * @param plantedTurn the plantedTurn to set
     */
    public void setPlantedTurn(int plantedTurn) {
        this.plantedTurn = plantedTurn;
    }

    /**
     * @param rechargeTime the rechargeTime to set
     */
    public void setRechargeTime(int rechargeTime) {
        this.rechargeTime = rechargeTime;
    }

    /**
     * @param spCost the spCost to set
     */
    public void setSpCost(int spCost) {
        this.spCost = spCost;
    }

    /**
     * @param rechargeCooldown the rechargeCooldown to set
     */
    public void setRechargeCooldown(int rechargeCooldown) {
        this.rechargeCooldown = rechargeCooldown;
    }

    public void damageByAmount(int amount) {
        this.currentHealth -= amount;
    }

    public void print(){
        System.out.println("Plant Name: " + this.getName() + " " + this.getRepresentation());
        System.out.println("Plant Stats:");
        System.out.println("\tMax Health: " + this.getMaxHealth());
        System.out.println("\tCurrent Health: " + this.getCurrentHealth());
        System.out.println("\tSP Cost: " + this.getSpCost());
        System.out.println("\tRecharge Time: " + this.getRechargeTime());
        System.out.println("\tAvailability Cooldown: " + this.getRechargeCooldown());
    }
}