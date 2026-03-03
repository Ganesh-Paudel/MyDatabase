public class CommandHandler {

    /**
     * Representation of a statement, for now it holds the stateemnt itself and the type of statement which is a enum defined
     * later
     * Has basic getters and setters for the statement and type
     */

    private static class Statement{
        private String statement;
        private StatementType sType;


        public Statement(){

        }

        public void setStatementType(StatementType sType){
            this.sType = sType;
        }

        public StatementType getStatementType(){
            return this.sType;
        }

        public void setStatement(String statement){
            this.statement = statement;
        }

        public String getStatement(){
            return this.statement;
        }
    }

    /**
     * Enum for different types of statements
     */
    private enum StatementType{
        SELECT,
        INSERT,

    }

    /**
     * Enum to distinguish if the command is meta command or not
     */
    private enum MetaCommand{
        META_COMMAND,
        NOTMETACOMMAND,
    }

    /**
     * Enum to identify the success (valid statement) or not
     */
    private enum StatementProcess{
        SUCCESS,
        FAILURE
    }

    // stores the statement object
    private final Statement statement;

    /**
     * Constructor for the class,
     * creates a instance of statement
     */
    public CommandHandler(){
        statement = new Statement();
    }


    /**
     * This method checks if the statement is meta command or not
     * @param statement the statement taht will be reviewed
     * @return return true if it is meta command and false if it's not
     */
    public boolean checkForMetaCommand(String statement){
        if(statement.startsWith(".")){
            switch (validMetaCommand(statement)){
                case MetaCommand.META_COMMAND -> {return true;}
                case MetaCommand.NOTMETACOMMAND -> {
                    System.out.println("Not a valid command: " + statement);
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Handlse the execution flow, called by input, It will check for valid statement and executes teh statement if valid
     */
    public void execute(){
        switch (validStatement(this.statement.getStatement())){
            case StatementProcess.SUCCESS -> {
            }
            case StatementProcess.FAILURE -> {
                System.out.println("Unrecognized statement at " + statement.getStatement());
                return;
            }
        }

        executeStatement(this.statement.getStatementType());
    }

    /**
     * called by execute to redirect to the statement functionality
     * @param sType the type of statement to clarify the function to point to
     */
    private void executeStatement(StatementType sType){
        switch (sType){
            case StatementType.INSERT -> System.out.println("Insert Command Detected");
            case StatementType.SELECT -> System.out.println("select command detected");
            default -> System.out.println("Invalid command");

        }
    }

    /**
     * Checks if it's one of the valid commands and sets the type for the statement from teh endum
     * @param statement the stattement given by user
     * @return returns the success or failure enum based on the validity of the statement
     */
    private StatementProcess validStatement(String statement){
        if(statement.startsWith("insert")){
            this.statement.setStatementType(StatementType.INSERT);
            return StatementProcess.SUCCESS;
        } else if(statement.startsWith("select")){
            this.statement.setStatementType(StatementType.SELECT);
            return StatementProcess.SUCCESS;
        } else{
            return StatementProcess.FAILURE;
        }
    }

    /**
     * checks if the given command is a meta command called by the meta command checker,
     * if not valid returns the meta command enum respectively
     * @param statement the statement that will be checkted
     * @return the equivalent meta command enum
     */
    private MetaCommand validMetaCommand(String statement){
        if(statement.startsWith(".exit")){
            return MetaCommand.META_COMMAND;
        } else{
            return MetaCommand.NOTMETACOMMAND;
        }

    }

    /**
     * Getter for the statement
     * @return returns a string statement
     */
    public String getStatement() {
        return this.statement.getStatement();
    }

    /**
     * setter for the statement
     * @param statement the value in string ofthe statement
     */
    public void setStatement(String statement) {
        this.statement.setStatement(statement);
    }

}
