// import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static String gameState = "MainScreen";
    public static void prompt(){
        System.out.print("Player@PlantsVsZombies:" + gameState + "$ ");
    }
    public static void main(String[] args) throws InterruptedException{
        boolean loopflag = true;
        Scanner input = new Scanner(System.in);
        Game game;

        clearConsole();

        System.out.println("======================");
        System.out.println("Plants vs Zombies Game");
        System.out.println("======================");
        System.out.print("\n");
        Main.showMainScreenHelp();

        while(loopflag){
            Main.prompt();
            String commandTemp = input.next();

            // 1. Play the Game
            if (commandTemp.equalsIgnoreCase("g") || commandTemp.equalsIgnoreCase("game") || commandTemp.equalsIgnoreCase("1")){
                gameState = "Game";
                game = new Game();
                game.playGame();
            } 
            // 2. Show Help Message
            else if (commandTemp.equalsIgnoreCase("h") || commandTemp.equalsIgnoreCase("help") || commandTemp.equalsIgnoreCase("2")) {
                showMainScreenHelp();
            }
            // 3. Exit Game
            else if (commandTemp.equalsIgnoreCase("e") || commandTemp.equalsIgnoreCase("exit") || commandTemp.equalsIgnoreCase("3")){
                System.out.println("Bye.");
                loopflag = false;
            } else {
                wrongInputCommand();
            }
            Thread.sleep(300);
        }
    }

    public static void clearConsole(){
        try{
            String os = System.getProperty("os.name");
            if (os.contains("Windows")){
                Runtime.getRuntime().exec("cls");
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void showMainScreenHelp(){
        System.out.println("Main Screen Instructions:");
        System.out.println("1. [Game / G / 1] = Play Game");
        System.out.println("2. [Help / H / 2] = Show This Message");
        System.out.println("3. [Exit / E / 3] = Exit The Game\n");
    }

    public static void showGameHelp(){
        System.out.println("Game Instructions:");
        System.out.println("1. Skip = Skip turns");
        System.out.println("2. Plant = Set plant in a tile");
        System.out.println("3. Remove = Remove a plant in a tile");
        System.out.println("4. Check = Check a tile");
        System.out.println("5. Help = Show this message");
        System.out.println("6. Exit = Exit the Game Stage");
    }

    public static void wrongInputCommand(){
        System.out.println("Wrong Input Command, read the instructions.");
    }
}