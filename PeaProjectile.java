public class PeaProjectile extends Projectile{
    public PeaProjectile(int turnShotFromPlant, Tile tile){
        super(
            4,                  // Standard Damage
            turnShotFromPlant,  // Turn Shot from Plant
            1,
            "-",             // Representation
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
        this.decreaseActionCD();
    }
}