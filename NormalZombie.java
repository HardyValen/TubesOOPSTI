public class NormalZombie extends Zombie{
 
    public NormalZombie(int spawnedTurn, Tile tile){
        super(
            spawnedTurn,    // Turn Spawned
            40,             // Max Health
            -1,             // Direction
            "Z",            // Representation
            "Normal Zombie",// Entity Name
            9,              // Action Time
            4,              // Attack Damage
            tile
        );
    }

    public void print(){
        super.print();
        System.out.println("An ordinary zombie");
    }
}