public class NormalZombie extends Zombie{
 
    public NormalZombie(int spawnedTurn, Tile tile){
        super(
            spawnedTurn,    // Turn Spawned
            40,             // Max Health
            -1,             // Direction
            0x1f636,        // 😶
            "Normal Zombie",// Entity Name
            5,              // Action Time
            4,              // Attack Damage
            tile
        );
    }

    public void print(){
        super.print();
        System.out.println("An ordinary zombie");
    }
}