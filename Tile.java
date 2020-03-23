import java.util.List;
import java.util.ArrayList;

class Tile{
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

        public void addEntity(Entity entity){
        String entityClass = entity.getClass().getSuperclass().getName();
        if (entityClass.equals("Plant")){
            boolean plantCheck = false;
            int i = 0;
            Entity plant = null;

            if (entities.size() != 0) {
                while (i < entities.size() || !plantCheck){
                    if (entities.get(i).getClass().getSuperclass().getName().equals("Plant")){
                        plantCheck = true;
                        plant = entities.get(i);
                    }
                    i++;
                }
            }

            if (plantCheck) {
                System.out.println("You cannot add a " + entity.getName() + " because you already placed a " + plant.getName() + " here");
            } else {
                this.entities.add(entity);
            }
        }
        if (this.entities.size() == 0) {
            this.setTileEntityRepresentation(entity.getRepresentation());
        }
    }

    public void removeEntity(int i){
        this.entities.remove(i);
        if (this.entities.size() == 0) {
            this.tileEntityRepresentation = " ";
        }
    }

    public void removeFirst(){
        this.removeEntity(0);
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

    public static void main(String[] args) {
        // List<List<Integer>> matrix = new ArrayList<List<Integer>>();

        // for(int i = 0; i < 5; i++){
        //     List<Integer> column = new ArrayList<Integer>();
        //     for(int j = 0; j < 10; j++){
        //         column.add(Integer.valueOf(j));
        //     }
        //     matrix.add(column);
        // }

        // for (List<Integer> list : matrix) {
        //     for (Integer data : list) {
        //         System.out.print(data);
        //     }
        //     System.out.print("\n");
        // }
        Tile tile = new Tile();
        Sunflower flowey = new Sunflower(10);
        Sunflower rose = new Sunflower(11);
        tile.addEntity(flowey);
        tile.addEntity(rose);
        
    }
}