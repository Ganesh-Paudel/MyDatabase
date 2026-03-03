import java.util.Scanner;

public class Input {

    public boolean isRunning = true;
    private String input;
    private Scanner scan = new Scanner(System.in);
    CommandHandler handler = new CommandHandler();

    public Input(){
        run();
    }

    private void run(){
       while(isRunning){
           sidePrompt();
           readInput();
           handler.setStatement(input);
           if(!handler.checkForMetaCommand(input)){
              handler.execute();
           } else{
               exitProgram();
           }
       }
       scan.close();

    }


    private void readInput(){
        input = scan.nextLine().toLowerCase();
    }

    private void sidePrompt(){
        System.out.print(" myDatabase>>> ");
    }

    private void exitProgram(){

        isRunning = false;
    }
}
