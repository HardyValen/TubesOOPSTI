public class PeaProjectile extends Projectile{
    public PeaProjectile(int turnShotFromPlant, int projectileDamage){
        super(
            projectileDamage,
            1,                   // MovementTime
            0x2022,             // •
            "Pea Projectile"    // Projectile Name
        );
        this.turnShotFromPlant = turnShotFromPlant;
    }

    public void print(){
        super.print();
        System.out.println("A small projectile that damages zombies somewhat");
    }

    public static void main(String[] args) {
        PeaProjectile pea = new PeaProjectile(0, 10);
        pea.print();
    }
}