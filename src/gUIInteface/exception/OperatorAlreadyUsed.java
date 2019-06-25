package gUIInteface.exception;



public class OperatorAlreadyUsed extends MasterClassGUIException {
    private static final String TOSHOW = "This operator is already in use";
    private static final String TITLE = "Error";

    /**
     * This constructor is called if an operator is already used
     */
    public OperatorAlreadyUsed(){
        super(TITLE,TOSHOW);
    }

}
