import java.util.List;
import java.util.ArrayList;

public class Row {
    protected List<Tile> tiles = new ArrayList<Tile>();
    protected final int size;

    public Row(int size){
        this.size = size;
        for(int j = 0; j < size; j++){
            tiles.add(new Tile());
        }
    }

    /**
     * @return the tiles
     */
    public List<Tile> getTiles() {
        return tiles;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    
}