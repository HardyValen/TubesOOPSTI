public class Repeater extends Plant implements Shootable{
    public static int plantRechargeCD = 0;
    public Repeater(int plantedTurn, Tile tile){
        super(
            10,             // maxHealth
            plantedTurn,    // plantedTurn
            200,            // spCost
            10,             // Turns to be Used Again
            0x2618,        // representation ☘️
            "Repeater",   // Plant name
            3,               // Action Time (Shoot Time)
            tile
        );
    }

    public void turnPass() {
        if(actionCD == 0){
            if (tile.row.hasZombie()) {
                this.shoot();
                this.shoot(); //shoot 2 peas
            }
            this.refreshActionCD();
        } else {
            this.decreaseActionCD();
        }
    }

    public void shoot(){
        tile.addProjectile(new PeaProjectile(Game.turn, tile));
    }

    public void setPlantRechargeCD(int plantRechargeCD) {
        Peashooter.plantRechargeCD = plantRechargeCD;
    }

    public void refreshPlantRechargeCD(){
        setPlantRechargeCD(getPlantRechargeTime());
    }

    public void print(){
        super.print();
        System.out.println("A Peashooter but fires twice as many peas.");
        System.out.println("Early Game Plant");
        System.out.println("Quite effective for clearing Horde of Zombies");
        System.out.println("");
    }
}