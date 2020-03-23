public abstract class Projectile extends Entity implements Printable{
    protected int movementTime;
    protected int projectileDamage;
    protected int turnShotFromPlant;

    public Projectile(
        int projectileDamage,
        int movementTime,
        int representation,
        String name
    ){
        super(representation);
        this.projectileDamage = projectileDamage;
        this.movementTime = movementTime;
        this.name = name;
    }

    /**
     * @return the projectileDamage
     */
    public int getProjectileDamage() {
        return projectileDamage;
    }

    /**
     * @return the turnShotFromPlant
     */
    public int getTurnShotFromPlant() {
        return turnShotFromPlant;
    }


    /**
     * @return the movementTime
     */
    public int getMovementTime() {
        return movementTime;
    }

    /**
     * @param projectileDamage the projectileDamage to set
     */
    public void setProjectileDamage(int projectileDamage) {
        this.projectileDamage = projectileDamage;
    }

    /**
     * @param turnShotFromPlant the turnShotFromPlant to set
     */
    public void setTurnShotFromPlant(int turnShotFromPlant) {
        this.turnShotFromPlant = turnShotFromPlant;
    }

    /**
     * @param movementTime the movementTime to set
     */
    public void setMovementTime(int movementTime) {
        this.movementTime = movementTime;
    }

    public void print(){
        System.out.println("Projectile Name: " + this.getName() + " " + this.getRepresentation());
        System.out.println("Projectile Stats:");
        System.out.println("\tMovementTime: " + this.getMovementTime());
        System.out.println("\tProjectile Damage: " + this.getProjectileDamage());
        System.out.println("\tShotted At: " + this.getTurnShotFromPlant());
    }
}