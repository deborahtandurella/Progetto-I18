package gUIInteface.exception;

/**
 * This class is used if the operator is already logged and cannot be used
 */

public class OperatorAlreadyLogged extends MasterClassGUIException {
    private static final String TOSHOW = "This operator is already logged in";
    private static final String TITLE = "Error";


    public OperatorAlreadyLogged(){
        super(TITLE,TOSHOW);
    }

}
