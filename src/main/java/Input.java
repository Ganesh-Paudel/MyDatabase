import java.util.Scanner;

public class Input {

    public boolean isRunning = true;
    private String input;
    private final Scanner scan = new Scanner(System.in);
    CommandHandler handler = new CommandHandler();

    public Input(){
        run();
    }

    /**
     * Main loop of the program until specified keeps running and prompting the user for command
     * And calls handler to process the statement unless it is a meta command which is executed by this class itself
     */
    private void run(){
       while(isRunning){
           sidePrompt();
           readInput();
           handler.setStatement(input);
           if (input != null && !handler.checkForMetaCommand(input)) {
               handler.execute();
           } else {
               exitProgram();
           }
       }
       scan.close();

    }

    /**
     * Read the line from the console and sets it as the input variable
     */
    private void readInput(){
        input = scan.nextLine().toLowerCase();
    }

    /**
     * prints the side prompt at the console
     */
    private void sidePrompt(){
        System.out.print(" myDatabase>>> ");
    }

    /**
     * Exits the program, sets the running variable to false, which causes the while loop to stop
     */
    private void exitProgram(){
        isRunning = false;
    }
}
