package gUIInteface.exception;



public class OperationAlreadyUsed extends MasterClassGUIException {
    private static final String TOSHOW = "This operation is already in use";
    private static final String TITLE = "Error";

    /**
     * This constructor is called if an operation target of a modification is already in use
     */
    public OperationAlreadyUsed() {
        super(TITLE,TOSHOW);
    }

}
