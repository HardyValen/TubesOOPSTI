public class Peashooter extends Plant{

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
        if(this.actionCD == 0){
            this.shoot();
        }
        super.turnPass();
    }

    public void shoot(){
        this.tile.addProjectile(new PeaProjectile(Game.turn, 1, this.getTile()));
    }

    public void print(){
        super.print();
        System.out.println("A Regular Peashooter");
        System.out.println("Early Game Plant");
        System.out.println("Not effective for clearing Horde of Zombies");
        System.out.println("");
    }

    

    public static void main(String[] args) {
        Tile tile = new Tile();
        Peashooter pea = new Peashooter(1, tile);
        
    }
}