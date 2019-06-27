package gUIInteface.exception;

/**
 * This class is used if the username can be correct but not the password
 */

public class WrongPassword extends MasterClassGUIException {
    private static final String TOSHOW = "The password is incorrect";
    private static final String TITLE = "Wrong Password";


    public WrongPassword() {
        super(TITLE,TOSHOW);
    }

}
