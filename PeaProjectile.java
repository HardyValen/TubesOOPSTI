public class PeaProjectile extends Projectile{
    public PeaProjectile(int turnShotFromPlant, int direction, Tile tile){
        super(
            4,                  // Standard Damage
            turnShotFromPlant,  // Turn Shot from Plant
            direction,
            0x2022,             // •
            "Pea Projectile",   // Projectile Name
            1,                   // Action Time (Move Time)
            tile,
            "normal"                 
        );
    }

    public void print(){
        super.print();
        System.out.println("A small projectile that damages zombies somewhat");
    }

    public void turnPass() {
        super.turnPass();
    }
}