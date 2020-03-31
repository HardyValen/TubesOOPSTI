public class BucketheadZombie extends Zombie{
 
    public BucketheadZombie(int spawnedTurn, Tile tile){
        super(
            spawnedTurn,    // Turn Spawned
            120,             // Max Health
            -1,             // Direction
            "B",            // Representation
            "Buckethead Zombie",// Entity Name
            9,              // Action Time
            4,              // Attack Damage
            tile
        );
    }

    public void print(){
        super.print();
        System.out.println("A very tanky zombie");
    }
}