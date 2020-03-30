public class Peashooter extends Plant implements Shootable{
    public static int plantRechargeCD = 0;
    public Peashooter(int plantedTurn, Tile tile){
        super(
            10,             // maxHealth
            plantedTurn,    // plantedTurn
            100,            // spCost
            10,             // Turns to be Used Again
            0x1f331,        // representation 🌱
            "Peashooter",   // Plant name
            3,               // Action Time (Shoot Time)
            tile
        );
    }

    public void turnPass() {
        if(actionCD == 0){
            if (tile.row.hasZombie()) {
                this.shoot();
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
        System.out.println("A Regular Peashooter");
        System.out.println("Early Game Plant");
        System.out.println("Not effective for clearing Horde of Zombies");
        System.out.println("");
    }
}