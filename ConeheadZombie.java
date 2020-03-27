public class ConeheadZombie extends Zombie{
 
    public ConeheadZombie(int spawnedTurn, Tile tile){
        super(
            spawnedTurn,    // Turn Spawned
            80,             // Max Health
            -1,             // Direction
            0x1f606,        // 😆
            "Normal Zombie",// Entity Name
            5,              // Action Time
            4,              // Attack Damage
            tile
        );
    }

    public void print(){
        super.print();
        System.out.println("A zombie with cone in the hat");
    }
}