// import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static boolean loopflag = true;
    public static String gameState = "MainScreen";
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException{
        clearConsole();

        System.out.println("======================");
        System.out.println("Plants vs Zombies Game");
        System.out.println("======================");
        System.out.print("\n\n");
        showMainScreenHelp();

        while(loopflag){
            inputCommand();
            Thread.sleep(1000);
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

    public static void inputCommand(){
        System.out.print("Player@PlantsVsZombies:" + gameState + "$ ");
        String commandTemp = input.next();

        if (gameState.equals("MainScreen")) {
            // 1. Play the Game
            if (commandTemp.equalsIgnoreCase("g") || commandTemp.equalsIgnoreCase("game") || commandTemp.equalsIgnoreCase("1")){
                gameState = "GameStage1";

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
        }
    }

    public static void wrongInputCommand(){
        System.out.println("Wrong Input Command, read the instructions.");
    }
}