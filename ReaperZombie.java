 public class ReaperZombie extends Zombie{
 
    public ReaperZombie(int spawnedTurn, Tile tile){
        super(
            spawnedTurn,    // Turn Spawned
            60,             // Max Health
            -1,             // Direction
            "R",        // Representation
            "Reaper Zombie",// Entity Name
            9,              // Action Time
            1000,           // Attack Damage
            tile
        );
    }

    public void print(){
        super.print();
        System.out.println("A one-hit kill zombie");
    }
}