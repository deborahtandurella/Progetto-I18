package gUIInteface.exception;



public class OperationNotFound extends MasterClassGUIException {
    private static final String TOSHOW = "Operation not found";
    private static final String TITLE = "Error";

    public OperationNotFound() {
        super(TITLE,TOSHOW);
    }

}
