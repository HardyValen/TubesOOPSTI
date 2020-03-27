public abstract class Plant extends Entity implements Damageable{
    // Plant Variables
    protected final int plantRechargeTime;
    protected int plantRechargeCD;
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
        Double initCD = Math.ceil(plantRechargeTime * 0.4);
        this.plantRechargeCD = initCD.intValue();
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
     * @return the plantRechargeCD
     */
    public int getPlantRechargeCD() {
        return plantRechargeCD;
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

    /**
     * @param plantRechargeCD the plantRechargeCD to set
     */
    public void setPlantRechargeCD(int plantRechargeCD) {
        this.plantRechargeCD = plantRechargeCD;
    }

    public void refreshPlantRechargeCD(){
        this.setPlantRechargeCD(this.getPlantRechargeTime());
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
        System.out.println("Plant Recharge Cooldown: " + this.getPlantRechargeCD());
        System.out.println("");
    }
}