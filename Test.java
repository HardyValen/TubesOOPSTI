import java.util.ArrayList;
import java.util.List;

class Test{
    public static void main(String[] args) {
        Tile tile = new Tile();
        tile.addEntity(new BucketheadZombie(1, tile));
        tile.addEntity(new BucketheadZombie(1, tile));
        tile.addEntity(new PeaProjectile(1, 1, tile));
        tile.addEntity(new PeaProjectile(2, 1, tile));
        tile.addEntity(new PeaProjectile(3, 1, tile));
        
        Tile tile2 = new Tile();
        tile2 = tile;
        tile2.removeEntity(1);
        for (Entity entity : tile2.getEntities()) {
            System.out.println(entity.getName());
        }

        tile.setEntities(tile2.entities);
    }
}