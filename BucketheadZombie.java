public class BucketheadZombie extends Zombie{
 
    public BucketheadZombie(int spawnedTurn, Tile tile){
        super(
            spawnedTurn,    // Turn Spawned
            150,             // Max Health
            -1,             // Direction
            0x1f602,        // 😂
            "Buckethead Zombie",// Entity Name
            5,              // Action Time
            4,              // Attack Damage
            tile
        );
    }

    public void print(){
        super.print();
        System.out.println("A very tanky zombie");
    }
}