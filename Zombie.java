public abstract class Zombie extends Entity implements Damageable, Movable, Damaging{
    // Zombie Variables
    protected int attackDamage;
    protected final int spawnedTurn;

    // Damageable Variables
    protected int maxHealth;
    protected int currentHealth;

    // Movable Variables
    protected int direction; // (Kanan ke Kiri)

    public Zombie(
        int spawnedTurn,
        int maxHealth,
        int direction,
        int representation,
        String name,
        int actionTime,
        int attackDamage,
        Tile tile
    ){
        super(representation, name, actionTime, tile);
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.attackDamage = attackDamage;
        this.spawnedTurn = spawnedTurn;
        this.direction = direction;
    }

    /**
     * @return the currentHealth
     */
    public int getCurrentHealth() {
        return currentHealth;
    }

    /**
     * @return the direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     * @return the maxHealth
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * @return the spawnedTurn
     */
    public int getSpawnedTurn() {
        return spawnedTurn;
    }

    /**
     * @param currentHealth the currentHealth to set
     */
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    /**
     * @param maxHealth the maxHealth to set
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void refreshHealth() {
        this.setCurrentHealth(this.getMaxHealth());
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void damageByAmount(int a) {
        this.setCurrentHealth(this.getCurrentHealth() - a);   
    }

    public void turnPass(){
        int thisTileIndex = tile.row.tiles.indexOf(tile);
        int nextTileIndex = thisTileIndex + direction;
        Plant plantTemp = tile.row.tiles.get(thisTileIndex).plant;
        
        if (plantTemp != null){
            plantTemp.damageByAmount(this.getAttackDamage());
        } else {
            if (nextTileIndex > 0 && nextTileIndex < tile.row.tiles.size()){
                Plant plantNext = tile.row.tiles.get(nextTileIndex).plant;
                if (plantNext != null) {
                    plantNext.damageByAmount(this.getAttackDamage());
                } else {
                    super.turnPass();    
                }
            } else {
                super.turnPass();
            }
        }
        // } else if (plantNext != null) {
        //     plantNext.damageByAmount(this.getAttackDamage());
        // } else {
        //     super.turnPass();
        // }
    }

    public void print(){
        super.print();
        System.out.println("Zombie Stats:");
        System.out.println("Max Health: " + this.getMaxHealth());
        System.out.println("Current Health: " + this.getCurrentHealth());
        System.out.println("Direction " + this.getDirection());
        System.out.println("Spawned on turn: " + this.getSpawnedTurn());
        System.out.println("");
    }
}