 public class ArmedZombie extends Zombie{
 
    public ArmedZombie(int spawnedTurn, Tile tile){
        super(
            spawnedTurn,    // Turn Spawned
            80,             // Max Health
            -1,             // Direction
            0x1f4aa,        // 💪
            "Armed Zombie",// Entity Name
            9,              // Action Time
            14,              // Attack Damage
            tile
        );
    }

    public void print(){
        super.print();
        System.out.println("A strong zombie");
    }
}