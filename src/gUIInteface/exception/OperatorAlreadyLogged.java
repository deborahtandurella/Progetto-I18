package gUIInteface.exception;



public class OperatorAlreadyLogged extends MasterClassGUIException {
    private static final String TOSHOW = "This operator is already logged in";
    private static final String TITLE = "Error";

    public OperatorAlreadyLogged(){
        super(TITLE,TOSHOW);
    }

}
