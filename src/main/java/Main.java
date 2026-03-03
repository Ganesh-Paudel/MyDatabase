import java.util.Locale;
import java.util.Scanner;

public class Main {

    static String input;
    static  boolean isRunning = true;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        while(isRunning){
           sidePrompt();
           readInput();

           input = input.toLowerCase();
           if(input.equals("exit") || input.equals("Quit")){
               exitProgram();
           } else{
               System.out.println("What is this command? HUH!!!!!, This is not a valid command.");
           }
        }
    }
    private static void readInput(){
       input = scan.nextLine();
    }

    private static void sidePrompt(){
        System.out.print(" myDatabase>>> ");
    }

    private static void exitProgram(){
       isRunning = false;
    }
}
