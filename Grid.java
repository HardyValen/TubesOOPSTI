import java.util.ArrayList;

public class Grid {
    ArrayList<Row> rows = new ArrayList<Row>();
    
    public Grid(int rowSize, int colSize){
        for (int i = 0; i < rowSize; i++) {
            rows.add(new Row(colSize, i));
        }
    }
}