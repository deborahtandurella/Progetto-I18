package gUIInteface.exception;

/**
 * This class is used if an operator is already used
 */

public class OperatorAlreadyUsed extends MasterClassGUIException {
    private static final String TOSHOW = "This operator is already in use";
    private static final String TITLE = "Error";


    public OperatorAlreadyUsed(){
        super(TITLE,TOSHOW);
    }

}
