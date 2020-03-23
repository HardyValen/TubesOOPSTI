public class Entity{
    protected String representation;
    protected String name;

    public Entity(int representation){
        this.representation = new StringBuilder().appendCodePoint(representation).toString();
    }

    public Entity(){
        this.representation = " ";
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
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public void turnPass(){}


}