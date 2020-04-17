import java.util.ArrayList;

public class Row{
    protected int position;
    protected ArrayList <Tile> tiles = new ArrayList<Tile>();
    protected Grid grid;

    public Row(int length, int position, Grid grid){
        this.position = position;
        for(int i = 0; i < length; i++){
            tiles.add(new Tile(this));
            tiles.get(i).posX = i;
            tiles.get(i).posY = position;
        }
        initialize();
        this.grid = grid;
    }

    private void initialize(){
        for (int i = 0; i < tiles.size(); i++) {
            tiles.get(i).setBounds(
                Constants.TILE_X_START + (Constants.TILE_WIDTH * (i + 1)),
                Constants.TILE_Y_START + (Constants.TILE_HEIGHT * position),
                Constants.TILE_WIDTH,
                Constants.TILE_HEIGHT
            );
        }
    }
}