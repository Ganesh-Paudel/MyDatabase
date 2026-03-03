public class CommandHandler {

    private class Statement{
        private String statement;
        private StatementType sType;

        public Statement(String statement){
            this.statement = statement;
        }

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

    private enum StatementType{
        SELECT,
        INSERT,

    }

    private enum MetaCommand{
        META_COMMAND,
        NOTMETACOMMAND,
    }

    private enum StatementProcess{
        SUCCESS,
        FAILURE
    }

    private Statement statement;

    public CommandHandler(){
        statement = new Statement();
    }


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

    public void execute(){
        switch (validStatement(this.statement.getStatement())){
            case StatementProcess.SUCCESS -> {
                break;
            }
            case StatementProcess.FAILURE -> {
                System.out.println("Unrecognized statement at " + statement.getStatement());
                return;
            }
        }

        executeStatement(this.statement.getStatementType());
    }

    private void executeStatement(StatementType sType){
        switch (sType){
            case StatementType.INSERT -> {
                System.out.println("Insert Command Detected");
                break;
            }
            case StatementType.SELECT -> {
                System.out.println("select command detected");
                break;
            }
            default -> {
                System.out.println("Invalid command");
            }

        }
    }

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

    private MetaCommand validMetaCommand(String statement){
        if(statement.startsWith(".exit")){
            return MetaCommand.META_COMMAND;
        } else{
            return MetaCommand.NOTMETACOMMAND;
        }

    }

    public String getStatement() {
        return this.statement.getStatement();
    }

    public void setStatement(String statement) {
        this.statement.setStatement(statement);
    }

}
