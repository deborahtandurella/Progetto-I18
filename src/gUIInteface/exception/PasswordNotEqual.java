package gUIInteface.exception;

/**
 * This class is used when if someone is trying to change username, the two password are not equal
 */

public class PasswordNotEqual extends MasterClassGUIException {
    private static final String TOSHOW = "The passwords are not the same";
    private static final String TITLE = "Error";


    public PasswordNotEqual() {
        super(TITLE,TOSHOW);
    }

}
