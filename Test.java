import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Test{
    public static boolean gameCheck(Grid grid){
        List<Tile> firstTiles = new ArrayList<Tile>();
        List<Integer> zombieCD = new ArrayList<Integer>();
        for (Row row : grid.rows) {
            firstTiles.add(row.getFirstTile());
        }

        for(Tile tile : firstTiles){
            for (Zombie zombie : tile.getZombies()) {
                zombieCD.add(Integer.valueOf(zombie.getActionCD()));
            }
        }
        
        return zombieCD.contains(Integer.valueOf(0));
    }
    public static void main(String[] args) throws InterruptedException {
        Grid grid = new Grid(5, 9);
        Random rand = new Random();
        boolean loop = true;

        while(loop){
            if (Game.turn % 35 == 30) {
                Tile tileTemp = grid.getRow(rand.nextInt(5)).getLastTile();
                switch (rand.nextInt(2)){
                    case 0:
                        tileTemp.addZombie(new ConeheadZombie(Game.turn, tileTemp));
                        break;
                    case 1:
                        tileTemp.addZombie(new BucketheadZombie(Game.turn, tileTemp));
                        break;
                    default:
                        tileTemp.addZombie(new NormalZombie(Game.turn, tileTemp));
                        break;
                }
            }

            if (Game.turn % 12 == 10) {
                Row rowTemp = grid.getRow(rand.nextInt(5));
                boolean flag = false;
                int i = 0;
                Tile tileTemp = rowTemp.getFirstTile();

                while (!flag && i < rowTemp.tiles.size()) {
                    if (tileTemp.getPlant() == null){
                        tileTemp.addPlant(new Peashooter(Game.turn, tileTemp));
                        flag = true;
                    } else {
                        i++;
                        if (i < rowTemp.tiles.size()) {
                            tileTemp = rowTemp.getTile(i);
                        }
                    }
                }
            }

            Thread.sleep(50);
            
            if (gameCheck(grid)) {
                loop = false;
                System.out.println("Game Over");
            } else {
                Main.clearConsole();
                Game.turn++;
                grid.turnPass();
                grid.print();
            }         
            
        }
    }
}