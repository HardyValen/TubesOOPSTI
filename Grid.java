import java.util.List;
import java.util.ArrayList;

public class Grid {
    protected List<Row> rows = new ArrayList<Row>();
    
    public Grid(int row, int column){
        for(int i = 0; i < row; i++){
            rows.add(new Row(column, this));
        }
    }
    
    public List<Row> getRows() {
        return rows;
    }

    public Row getRow(int i){
        if (i < rows.size()) {
            return rows.get(i);
        } else {
            return null;
        }
    }

    public Tile getTile(int rowIdx, int colIdx){
        return rows.get(rowIdx).tiles.get(colIdx);
    }

    public Tile getTile(Pair<Integer, Integer> index){
        return rows.get(index.getKey()).tiles.get(index.getValue());
    }

    public void turnPass(){
        for (Row row : rows) {
            row.turnPass();
        }
    }

    public void print(){
        System.out.println("   |0|1|2|3|4|5|6|7|8|");
        System.out.println("   *******************");
        int i = 0;
        for (Row row : rows) {
            System.out.print(i + "  ");
            row.print();
            System.out.println("");
            i++;
        }
        System.out.println("   *******************");
    }
}