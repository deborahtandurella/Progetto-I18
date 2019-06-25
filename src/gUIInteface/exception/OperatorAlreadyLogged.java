package gUIInteface.exception;



public class OperatorAlreadyLogged extends MasterClassGUIException {
    private static final String TOSHOW = "This operator is already logged in";
    private static final String TITLE = "Error";

    /**
     * This constructor is called if the operator is alrady logged and cannot be used
     */
    public OperatorAlreadyLogged(){
        super(TITLE,TOSHOW);
    }

}
