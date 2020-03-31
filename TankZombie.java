 public class TankZombie extends Zombie{
 
    public TankZombie(int spawnedTurn, Tile tile){
        super(
            spawnedTurn,    // Turn Spawned
            350,             // Max Health
            -1,             // Direction
            0x1f9df,        // 🧟‍♂️
            "Tank Zombie",// Entity Name
            6,              // Action Time
            8,              // Attack Damage
            tile
        );
    }

    public void print(){
        super.print();
        System.out.println("A ripped zombie");
    }
}