public class Sunflower extends Plant implements Generable{
    protected int generateSPValue;
    public static int plantRechargeCD = 0;

    public Sunflower(int plantedTurn, Tile tile){
        super(
            10,             // maxHealth
            plantedTurn,    // plantedTurn
            50,             // spCost
            10,             // Plant Recharge
            0x1f33b,         // representation 🌻
            "Sunflower",    // name
            12,             // Action Time
            tile            // Tile
        );

        this.generateSPValue = 25;      // SP Value get when SP not cooldown
    }

    /**
     * @return the generateSPValue
     */
    public int getGenerateSPValue() {
        return generateSPValue;
    }

    public void setPlantRechargeCD(int plantRechargeCD) {
        Sunflower.plantRechargeCD = plantRechargeCD;
    }

    public void refreshPlantRechargeCD(){
        setPlantRechargeCD(getPlantRechargeTime());
    }

    public void print(){
        super.print();
        System.out.println("Sunflower Specific Stats:");
        System.out.println("Generate SP Value: " + this.getGenerateSPValue());
        System.out.println("Sunflower Recharge Cooldown: " + Sunflower.plantRechargeCD);
        System.out.println("");
        System.out.println("Sunflower is your SP Generator\n");
    }

    public void turnPass() {
        if (this.getActionCD() == 0) {
            Game.spPoints += this.getGenerateSPValue();
            this.refreshActionCD();
        } else {
            this.decreaseActionCD();
        }
    }
}