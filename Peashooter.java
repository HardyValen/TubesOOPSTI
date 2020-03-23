import java.util.List;
import java.util.ArrayList;

public class Peashooter extends Plant implements Shootable{
    protected int attackDamage = 2;
    protected int attackCooldown = 1;
    protected int attackTime = 2;
    protected List<PeaProjectile> projectiles = new ArrayList<PeaProjectile>();

    public Peashooter(int plantedTurn){
        super(
            10,             // maxHealth
            plantedTurn,    // plantedTurn
            100,            // spCost
            10,             // Turns to be Used Again
            "Peashooter",   // Plant name
            0x1f331         // representation 🌱
        );
    }

    /**
     * @return the attackDamage
     */
    public int getAttackDamage() {
        return attackDamage;
    }

    /**
     * @return the attackCooldown
     */
    public int getAttackCooldown() {
        return attackCooldown;
    }

    /**
     * @return the attackTime
     */
    public int getAttackTime() {
        return attackTime;
    }

    /**
     * @return the projectiles
     */
    public List<PeaProjectile> getProjectiles() {
        return projectiles;
    }

    /**
     * @param attackCooldown the attackCooldown to set
     */
    public void setAttackCooldown(int attackCooldown) {
        this.attackCooldown = attackCooldown;
    }

    /**
     * @param attackTime the attackTime to set
     */
    public void setAttackTime(int attackTime) {
        this.attackTime = attackTime;
    }

    /**
     * @param attackDamage the attackDamage to set
     */
    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void addProjectile(){
        PeaProjectile peaProjectile = new PeaProjectile(Game.turn, this.getAttackDamage());
        this.projectiles.add(peaProjectile);
    }

    public void removeProjectile(int i){
        this.projectiles.remove(i);
    }

    public void removeFirstProjectile(){
        this.removeProjectile(0);
    }

    public void shoot(){
        this.addProjectile();
    }
    
    public void turnPass(){
        int atkCooldown = this.getAttackCooldown();
        int atkTime = this.getAttackTime();
        if (atkCooldown == 0) {
            this.shoot();
            this.setAttackCooldown(atkTime);
        } else {
            this.setAttackCooldown(atkCooldown - 1);
        }
    }

    public void print(){
        super.print();
        System.out.println("\nPeashooter Specific Stats:");
        System.out.println("\tAttack Damage: " + this.getAttackDamage());
        System.out.println("\tAttack Cooldown: " + this.getAttackCooldown());
        System.out.println("\tAttack Time: " + this.getAttackTime());
        System.out.println("\nA Regular Peashooter");
        System.out.println("Early Game Plant");
        System.out.println("Not effective for clearing Horde of Zombies");
    }

    public static void main(String[] args) {
        Peashooter pea = new Peashooter(10);
        pea.print();

        for(int i = 0; i < 10; i++){
            pea.turnPass();
            System.out.println(pea.getAttackCooldown());
        }
    }
}