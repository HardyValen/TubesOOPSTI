import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    public static int turn;
    public static int spPoints;
    protected Grid grid;
    public static boolean loop = true;
    
    public Game(){
        Game.turn = 0;
        Game.spPoints = 50;
        grid = new Grid(5, 9);
    }

    public void turnPass() throws InterruptedException{
        Thread.sleep(100);
        
        if (Sunflower.plantRechargeCD != 0) {
            Sunflower.plantRechargeCD -= 1;
        }

        if (Wallnut.plantRechargeCD != 0) {
            Wallnut.plantRechargeCD -= 1;
        }

        if (Peashooter.plantRechargeCD != 0) {
            Peashooter.plantRechargeCD -= 1;
        }

        if (Game.turn % 6 == 4) {
            Game.spPoints += 25;
        }

        if (Game.turn % 20 == 19){
            Random rand = new Random();
            Tile tileTemp = grid.getRow(rand.nextInt(5)).getLastTile();
            tileTemp.addZombie(new NormalZombie(Game.turn, tileTemp));

            if (Game.turn > 200) {
                tileTemp = grid.getRow(rand.nextInt(5)).getLastTile();
                tileTemp.addZombie(new NormalZombie(Game.turn, tileTemp));
            }
        }

        if (Game.turn % 100 == 99){
            Random rand = new Random();
            Tile tileTemp = grid.getRow(rand.nextInt(5)).getLastTile();
            tileTemp.addZombie(new ConeheadZombie(Game.turn, tileTemp));

            if (Game.turn > 600) {
                tileTemp = grid.getRow(rand.nextInt(5)).getLastTile();
                tileTemp.addZombie(new ConeheadZombie(Game.turn, tileTemp));
            }
        }

        if (Game.turn % 150 == 0 && Game.turn > 150){
            Random rand = new Random();
            Tile tileTemp = grid.getRow(rand.nextInt(5)).getLastTile();
            tileTemp.addZombie(new BucketheadZombie(Game.turn, tileTemp));
        }
      
        if (Game.turn % 200 == 0 && Game.turn > 200){
            Random rand = new Random();
            Tile tileTemp = grid.getRow(rand.nextInt(5)).getLastTile();
            tileTemp.addZombie(new BucketheadZombie(Game.turn, tileTemp));
        }

        if (Game.turn % 250 == 0 && Game.turn > 250){
            Random rand = new Random();
            Tile tileTemp = grid.getRow(rand.nextInt(5)).getLastTile();
            tileTemp.addZombie(new TankZombie(Game.turn, tileTemp));
        }

        if (Game.turn % 300 == 0 && Game.turn > 300){
            Random rand = new Random();
            Tile tileTemp = grid.getRow(rand.nextInt(5)).getLastTile();
            tileTemp.addZombie(new ReaperZombie(Game.turn, tileTemp));
        }



        if (Game.gameCheck(grid)) {
            Game.loop = false;
        } else {
            Main.clearConsole();
            Game.turn++;
            grid.turnPass();
            this.print();
        }
    }    

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

    public void print(){
        System.out.println("Sunflower Points: " + Game.spPoints);
        System.out.println("Turn: " + Game.turn);
        grid.print();
        System.out.println("1. Sunflower(CD: " + Sunflower.plantRechargeCD + "  Cost: 50)");
        System.out.println("2. Peashooter(CD: " + Peashooter.plantRechargeCD + "  Cost: 100)");
        System.out.println("3. Wallnut(CD: " + Wallnut.plantRechargeCD + "  Cost: 50)");
        System.out.println("");
    }

    public Tile selectTile(){
        Scanner input = new Scanner(System.in);
        Pair<Integer, Integer> rowIndexExt = new Pair<Integer,Integer>(
            Integer.valueOf(0), Integer.valueOf(this.grid.rows.size() - 1)
        );
        System.out.println("Select Row: [ " + rowIndexExt.getKey() + ".." + rowIndexExt.getValue() + " ]");
        int rowIndex = input.nextInt();
        boolean rowIndexLoop = true;

        while (rowIndexLoop) {
            if (rowIndex >= rowIndexExt.getKey() && rowIndex <= rowIndexExt.getValue()) {
                rowIndexLoop = false;   
            } else {
                System.out.println("Please insert integer [ " + rowIndexExt.getKey() + ".." + rowIndexExt.getValue() + " ]");
                rowIndex = input.nextInt();
            }
        }
        
        Row selectedRow = this.grid.getRow(rowIndex);
        Pair<Integer, Integer> colIndexExt = new Pair<Integer,Integer>(
            Integer.valueOf(0), Integer.valueOf(selectedRow.tiles.size() - 1)
        );
        System.out.println("Select Column:  [ " + colIndexExt.getKey() + ".." + colIndexExt.getValue() + " ]");
        int colIndex = input.nextInt();
        boolean colIndexLoop = true;

        while (colIndexLoop) {
            if (colIndex >= colIndexExt.getKey() && colIndex <= colIndexExt.getValue()) {
                colIndexLoop = false;   
            } else {
                System.out.println("Please insert integer [ " + colIndexExt.getKey() + ".." + colIndexExt.getValue() + " ]");
                colIndex = input.nextInt();
            }
        }

        return this.grid.getTile(
            new Pair<Integer, Integer>(
                Integer.valueOf(rowIndex),
                Integer.valueOf(colIndex)
            )
        );
    }

    public void playGame() throws InterruptedException{
        Scanner input = new Scanner(System.in);

        Main.clearConsole();
        this.print();
        Main.showGameHelp();
        System.out.println("");

        while(Game.loop == true){
            Main.prompt();
            String command = input.next();
            
            if(command.equalsIgnoreCase("skip") || command.equalsIgnoreCase("s") || command.equalsIgnoreCase("1")){
                System.out.print("How Many Turns? ");
                int skipTurns = input.nextInt();
                if (skipTurns < 1) {
                    skipTurns = 1;
                }
                while(skipTurns > 0 && !Game.gameCheck(grid)){
                    this.turnPass();
                    skipTurns--;
                }

                if (Game.gameCheck(grid)) {
                    Game.loop = false;
                    Main.gameState = "MainScreen";
                    System.out.println("Game Over, Exitting the game");
                }
            } 
            
            else if (command.equalsIgnoreCase("plant") || command.equalsIgnoreCase("p") || command.equalsIgnoreCase("2")) {
                System.out.println("Select Plant: ");
                System.out.println("1. Sunflower ");
                System.out.println("2. Peashooter ");
                System.out.println("3. Wallnut ");
                
                int plantType = input.nextInt();
                boolean plantLoop = true;

                while (plantLoop) {
                    if (plantType >= 1 && plantType <= 3) {
                        plantLoop = false;  
                    } else {
                        System.out.println("Please insert integer [1 .. 3]");
                        plantType = input.nextInt();
                    }
                }

                Tile selectedTile = this.selectTile();

                Plant plantTemp = null;
                int plantRechargeCD = 0;

                if (plantType == 1) {
                    plantTemp = new Sunflower(Game.turn, selectedTile);
                    plantRechargeCD = Sunflower.plantRechargeCD;
                } else if (plantType == 2) {
                    plantTemp = new Peashooter(Game.turn, selectedTile);
                    plantRechargeCD = Peashooter.plantRechargeCD;
                } else if (plantType == 3) {
                    plantTemp = new Wallnut(Game.turn, selectedTile);
                    plantRechargeCD = Wallnut.plantRechargeCD;
                }

                if (Game.spPoints >= plantTemp.getSpCost()) {
                    if (plantRechargeCD == 0) {
                        if (selectedTile.getPlant() == null){
                            Game.spPoints -= plantTemp.getSpCost();
                            selectedTile.addPlant(plantTemp);
                            if (plantType == 1) {
                                Sunflower.plantRechargeCD = plantTemp.getPlantRechargeTime();
                            } else if (plantType == 2) {
                                Peashooter.plantRechargeCD = plantTemp.getPlantRechargeTime();
                            } else if (plantType == 3) {
                                Wallnut.plantRechargeCD = plantTemp.getPlantRechargeTime();
                            }
                            this.clear();
                            System.out.println(plantTemp.getName() + " Planted Successfully");
                        } else {
                            this.clear();
                            selectedTile.addPlant(plantTemp);
                        }
                    } else {
                        this.clear();
                        System.out.println("The plant is still on cooldown");
                        System.out.println("Recharge time: " + plantRechargeCD);
                    }
                    
                } else {
                    this.clear();
                    System.out.println("Insufficient SP Points");
                    System.out.println("You only have " + Game.spPoints);
                }
            }
        
            else if (command.equalsIgnoreCase("remove") || command.equalsIgnoreCase("r") || command.equalsIgnoreCase("3")){
                Tile selectedTile = selectTile();
                if (selectedTile.plant != null){
                    selectedTile.plant = null;
                    this.clear();
                    System.out.println("Plant Cleared Successfully");
                } else {
                    this.clear();
                    System.out.println("There was no plant in the selected tile");
                } 
            }
            
            else if (command.equalsIgnoreCase("check") || command.equalsIgnoreCase("c") || command.equalsIgnoreCase("4")){
                Tile selectTile = this.selectTile();
                Main.clearConsole();
                this.print();
                selectTile.printDetail();
            }
            
            else if (command.equalsIgnoreCase("help") || command.equalsIgnoreCase("h") || command.equalsIgnoreCase("5")) {
                this.clear();
                Main.showGameHelp();
            }
            
            else if (command.equalsIgnoreCase("exit") || command.equalsIgnoreCase("e") || command.equalsIgnoreCase("6")) {
                    Game.loop = false;
                    Main.clearConsole();
                    System.out.println("Exitting the game");
                    Main.gameState = "MainScreen";
                } 

            else {
                System.out.println("Please check the instruction.");
            }
        }
    }


    public void clear(){
        Main.clearConsole();
        this.print();
    }
}