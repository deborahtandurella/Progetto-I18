package gUIInteface.exception;

/**
 * This class is used if an operator can' t be found
 */

public class OperatorNotFound extends MasterClassGUIException {
    private static final String TOSHOW = "Operator not found";
    private static final String TITLE="Error";


    public OperatorNotFound(){
        super(TITLE,TOSHOW);
    }

}
