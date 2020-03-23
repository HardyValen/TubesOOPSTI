public class Sunflower extends Plant{
    protected int generateSPValue;
    protected int generateSPTime;
    protected int generateSPCooldown;

    public Sunflower(int plantedTurn){
        super(
            10,             // maxHealth
            plantedTurn,    // plantedTurn
            50,             // spCost
            10,             // Turns to be Used Again
            "Sunflower",    // name
            0x1f33b         // representation 🌻
        );

        this.generateSPValue = 25;      // SP Value get when SP not cooldown
        this.generateSPTime = 5;        // Turn Passes to get SP
        this.generateSPCooldown = 4;    // Initial Turn Pass Cooldown
    }

    /**
     * @return the generateSPValue
     */
    public int getGenerateSPValue() {
        return generateSPValue;
    }

    /**
     * @return the generateSPCooldown
     */
    public int getGenerateSPCooldown() {
        return generateSPCooldown;
    }

    /**
     * @return the generateSPTime
     */
    public int getGenerateSPTime() {
        return generateSPTime;
    }

    /**
     * @param generateSPValue the generateSPValue to set
     */
    public void setGenerateSPValue(int generateSPValue) {
        this.generateSPValue = generateSPValue;
    }

    /**
     * @param generateSPCooldown the generateSPCooldown to set
     */
    public void setGenerateSPCooldown(int generateSPCooldown) {
        this.generateSPCooldown = generateSPCooldown;
    }

    /**
     * @param generateSPTime the generateSPTime to set
     */
    public void setGenerateSPTime(int generateSPTime) {
        this.generateSPTime = generateSPTime;
    }

    public void print(){
        super.print();
        System.out.println("\nSunflower Specific Stats:");
        System.out.println("\tGenerate SP Value: " + this.getGenerateSPValue());
        System.out.println("\tGenerate SP Time: " + this.getGenerateSPTime());
        System.out.println("\tGenerate SP Cooldown: " + this.getGenerateSPCooldown());
        System.out.println("\nSunflower is your SP Generator");
    }

    public void turnPass() {
        int spCooldown = this.getGenerateSPCooldown();
        int spTime = this.getGenerateSPTime();
        if (spCooldown == 0){
            Game.spPoints += this.getGenerateSPValue();
            this.setGenerateSPCooldown(spTime);
        } else {
            this.setGenerateSPCooldown(spCooldown - 1);
        }
    }
}