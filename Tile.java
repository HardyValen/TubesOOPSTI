import java.util.List;
import java.util.ArrayList;

public class Tile{
    protected List<Entity> entities = new ArrayList<Entity>();
    protected String tileEntityRepresentation;

    public Tile(){
        this.tileEntityRepresentation = " ";
    }

    public List<Entity> getEntities(){
        return this.entities;
    }

    public String getTileEntityRepresentation() {
        return tileEntityRepresentation;
    }

    public void setTileEntityRepresentation(String tileEntityRepresentation) {
        this.tileEntityRepresentation = tileEntityRepresentation;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public void addEntity(Entity entity){
        if (entity.getClass().getSuperclass().getSimpleName().equals("Plant")) {
            if (this.hasSuperClass("Plant")) {
                System.out.println("You cannot plant " + entity.getName() + " because this tile has already have a plant");
            } else {
                System.out.println(entity.getName() + " planted successfully");
                this.entities.add(entity);
                this.setTileEntityRepresentation(entity.getRepresentation());
            }
        } else {
            this.entities.add(entity);
            this.setTileEntityRepresentation(entity.getRepresentation());
        }
    }

    public void removeEntity(int i){
        this.entities.remove(i);
        if (this.entities.size() == 0) {
            this.tileEntityRepresentation = " ";
        } else {
            this.tileEntityRepresentation = this.entities.get(0).getRepresentation();
        }
    }

    public void removeFirst(){
        if (this.entities.size() > 0){
            this.removeEntity(0);
        }
    }

    public void print(){
        System.out.print(this.getTileEntityRepresentation());
    }

    public void printInfo(){
        if(this.entities.size() == 0){
            System.out.println("There's nothing in this tile");
        } else {
            System.out.print("This tile contains " + this.entities.size() + " objects: ");
            for (Entity entity : entities) {
                System.out.print(entity.getRepresentation());
            }
            System.out.print("\n");
        }
    }

    
    public List<Entity> getEntities(String className){
        List<Entity> temp = new ArrayList<Entity>();
        for (Entity entity : entities) {
            if (entity.getClass().getSuperclass().getSimpleName().equals(className)) {
                temp.add(entity);
            }
        }
        return temp;
    }
    
    public List<Integer> getEntitiesIndexListFromSuperclass(String className){
        List<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).getClass().getSuperclass().getSimpleName().equals(className)) {
                temp.add(Integer.valueOf(i));
            }
        }
        return temp;
    }
    public boolean hasSuperClass(String className){
        boolean hasFlag = false;
        int size = entities.size();
        if (size == 0){
            return hasFlag;
        } else {
            int counter = 0;
            while(!hasFlag && counter < size) {
                String entityName = entities.get(counter).getClass().getSuperclass().getSimpleName();
                if (entityName.equals(className)) {
                    hasFlag = true;
                }
                counter += 1;
            }
        }
        return hasFlag;
    }

    public void 
    
    public void nextTurn() {
        
        for (int i = 0; i < entities.size(); i++) {
            this.entities.get(i).turnPass();
        }
    }
    public static void main(String[] args) {
        Tile tile = new Tile();
        tile.addEntity(new Sunflower(1, tile));
        System.out.println(tile.hasSuperClass("Plant"));
    }
}