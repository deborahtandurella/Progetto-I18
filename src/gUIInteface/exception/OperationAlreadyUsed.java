package gUIInteface.exception;

/**
 * This class is used if an operation target of a modification is already in use
 */

public class OperationAlreadyUsed extends MasterClassGUIException {
    private static final String TOSHOW = "This operation is already in use";
    private static final String TITLE = "Error";


    public OperationAlreadyUsed() {
        super(TITLE,TOSHOW);
    }

}
