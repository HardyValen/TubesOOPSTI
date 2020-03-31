public abstract class Projectile extends Entity implements Movable, Damaging{
    // Projectile Variables
    protected int attackDamage;
    protected final int turnShotFromPlant;
    protected final String projectileType;

    // Movable Variables
    protected int direction; // (Kiri ke Kanan)

    public Projectile(
        int attackDamage,
        int turnShotFromPlant,
        int direction,
        int representation,
        String name,
        int actionTime,
        Tile tile,
        String projectileType
    ){
        super(representation, name, actionTime, tile);
        this.attackDamage = attackDamage;
        this.turnShotFromPlant = turnShotFromPlant;
        this.direction = direction;
        this.projectileType = projectileType;
    }

    /**
     * @return the attackDamage
     */
    public int getAttackDamage() {
        return attackDamage;
    }

    /**
     * @return the turnShotFromPlant
     */
    public int getTurnShotFromPlant() {
        return turnShotFromPlant;
    }

    /**
     * @return the direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     * @return the projectileType
     */
    public String getProjectileType() {
        return projectileType;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * @param attackDamage the attackDamage to set
     */
    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Projectile Stats:");
        System.out.println("Projectile Damage: " + this.getAttackDamage());
        System.out.println("Turn Shot From Plant:" + this.getTurnShotFromPlant());
        System.out.println("Direction :" + this.getDirection());
        System.out.println("");
    }
}