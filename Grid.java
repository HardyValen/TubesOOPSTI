import java.util.ArrayList;

public class Grid {
    protected ArrayList<Row> rows = new ArrayList<Row>();
    protected int rowSize;
    protected int colSize;
    
    public Grid(int rowSize, int colSize){
        for (int i = 0; i < rowSize; i++) {
            rows.add(new Row(colSize, i, this));
        }

        this.rowSize = rowSize;
        this.colSize = colSize; 
    }

    public void setEnableAll(boolean b){
        for (Row row : rows) {
            for(Tile tile : row.tiles){
                tile.setEnabled(b);
            }
        }
    }
}