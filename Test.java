import java.util.ArrayList;
import java.util.List;

class Test{
    public static void main(String[] args) {
        Tile tile = new Tile();
        tile.addZombie(new BucketheadZombie(1, tile));
        tile.addPlant(new Peashooter(1, tile));

        tile.printDetail();
        tile.turnPass();
        tile.turnPass();
        tile.turnPass();
        tile.printDetail();
    }
}