public class Wallnut extends Plant{
    public static int plantRechargeCD = 0;

    public Wallnut(int plantedTurn, Tile tile){
        super(
            200,             // maxHealth
            plantedTurn,    // plantedTurn
            50,             // spCost
            60,             // Plant Recharge
            0x1f95c,         // representation 🥜
            "Wallnut",    // name
            60,             // Action Time
            tile            // Tile
        );

   }

    public void setPlantRechargeCD(int plantRechargeCD) {
        Wallnut.plantRechargeCD = plantRechargeCD;
    }

    public void refreshPlantRechargeCD(){
        setPlantRechargeCD(getPlantRechargeTime());
    }

    public void print(){
        super.print();
        System.out.println("Your Tankish Plant");
        System.out.println("Plant Recharge Cooldown: " + Wallnut.plantRechargeCD + "\n");
    }

    public void turnPass() {
        if (actionCD == 0){
            refreshActionCD();
        } else {
            this.decreaseActionCD();
        }
    }
}