public class NormalZombie extends Zombie{
    public NormalZombie(int spawnedTurn){
        super(
            20,             // Max Health
            spawnedTurn,    // Turn Spawned
            5,              // Turns to Move
            0x1f636,        // 😶
            4,              // Attack Damage
            "Normal Zombie" // Entity Name
        );
    }

    public void print(){
        super.print();
        System.out.println("An ordinary zombie");
    }
}