package gUIInteface.exception;



public class OperationNotFound extends MasterClassGUIException {
    private static final String TOSHOW = "Operation not found";
    private static final String TITLE = "Error";

    /**
     * This constructor is called if a defined operation can' t be found
     */
    public OperationNotFound() {
        super(TITLE,TOSHOW);
    }

}
