public abstract class Entity{
    protected final String representation;
    protected final String name;
    protected final int actionTime;
    protected int actionCD;
    protected Tile tile;

    public Entity(
        String representation, 
        String name,
        int actionTime,
        Tile tile
    ){ 
        this.representation = representation;
        this.actionTime = actionTime;
        this.actionCD = actionTime;
        this.name = name;
        this.tile = tile;
    }

    /**
     * @return the representation
     */
    public String getRepresentation() {
        return this.representation;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the actionCD
     */
    public int getActionCD() {
        return actionCD;
    }

    /**
     * @return the actionTime
     */
    public int getActionTime() {
        return actionTime;
    }

    /**
     * @return the tile
     */
    public Tile getTile() {
        return tile;
    }

    /**
     * @param actionCD the actionCD to set
     */
    public void setActionCD(int actionCD) {
        this.actionCD = actionCD;
    }

    /**
     * @param tile the tile to set
     */
    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public void refreshActionCD(){
        this.setActionCD(this.getActionTime());
    }

    public void actionCheck(){
        if (this.actionCD <= 0) {
            this.refreshActionCD();
        }
    }

    public void decreaseActionCD(){
        this.setActionCD(this.getActionCD() - 1);
    }

    public void turnPass(){
        this.decreaseActionCD();
    }

    public void print(){
        System.out.println("Entity Stats:");
        System.out.println("Entity Representation: " + this.getRepresentation());
        System.out.println("Entity Name: " + this.getName());
        System.out.println("Entity Action Time: " + this.getActionTime());
        System.out.println("Entity Action Cooldown:" + this.getActionCD());
        System.out.println("");
    }
}