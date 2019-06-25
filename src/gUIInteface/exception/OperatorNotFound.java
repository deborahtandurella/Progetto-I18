package gUIInteface.exception;



public class OperatorNotFound extends MasterClassGUIException {
    private static final String TOSHOW = "Operator not found";
    private static final String TITLE="Error";

    /**
     * This constructor is called if an operator can' t be found
     */
    public OperatorNotFound(){
        super(TITLE,TOSHOW);
    }

}
