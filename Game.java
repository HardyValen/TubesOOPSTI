import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Game {
    public static int turn;
    public static int spPoints;
    protected int gameStage;
    protected List<List<Tile>> gameGrid = new ArrayList<List<Tile>>();
    
    public Game(){
        Game.turn = 0;
        Game.spPoints = 0;
        this.gameStage = 1;

        for(int i = 0; i < 5; i++){
            List<Tile> gameRow = new ArrayList<Tile>();
            for(int j = 0; j < 10; j++){
                gameRow.add(new Tile());
            }
            this.gameGrid.add(gameRow);
        }
    }

    /**
     * @return the spPoints
     */
    public int getSpPoints() {
        return spPoints;
    }

    /**
     * @return the gameStage
     */
    public int getGameStage() {
        return gameStage;
    }

    /**
     * @param spPoints the spPoints to set
     */
    public void setSpPoints(int spPoints) {
        Game.spPoints = spPoints;
    }

    /**
     * @param gameStage the gameStage to set
     */
    public void setGameStage(int gameStage) {
        this.gameStage = gameStage;
    }

    public void nextTurn(){
        Game.turn += 1;
        for (List<Tile> list : gameGrid) {
            for (Tile tile : list) {
                for (Entity entity : tile.getEntities()) {
                    entity.turnPass();
                }
            }
        }
    }

    public static void main(String[] args) {
        
    }
}