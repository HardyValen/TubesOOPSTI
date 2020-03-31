public abstract class Plant extends Entity implements Damageable{
    // Plant Variables
    protected final int plantRechargeTime;
    protected final int spCost;
    protected final int plantedTurn;

    // Damageable Variables
    protected int maxHealth;
    protected int currentHealth;

    public Plant(
        int maxHealth,
        int plantedTurn,
        int spCost,
        int plantRechargeTime,
        int representation,
        String name,
        int actionTime,
        Tile tile
    ){
        super(representation, name, actionTime, tile);
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.plantedTurn = plantedTurn;
        this.spCost = spCost;
        this.plantRechargeTime = plantRechargeTime;
    }

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
     * @return the plantRechargeTime
     */
    public int getPlantRechargeTime() {
        return plantRechargeTime;
    }

    /**
     * @return the plantedTurn
     */
    public int getPlantedTurn() {
        return plantedTurn;
    }

    /**
     * @return the spCost
     */
    public int getSpCost() {
        return spCost;
    }

    /**
     * @param currentHealth the currentHealth to set
     */
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void damageByAmount(int a) {
        this.setCurrentHealth(this.getCurrentHealth() - a);
    }

    public void refreshHealth() {
        this.setCurrentHealth(this.getMaxHealth());
    }

    public void print(){
        super.print();
        System.out.println("Plant Stats:");
        System.out.println("Max Health: " + this.getMaxHealth());
        System.out.println("Current Health: " + this.getCurrentHealth());
        System.out.println("Planted Turn: " + this.getPlantedTurn());
        System.out.println("SP Cost: " + this.getSpCost());
        System.out.println("Plant Recharge Time: " + this.getPlantRechargeTime());
        System.out.println("");
    }
}