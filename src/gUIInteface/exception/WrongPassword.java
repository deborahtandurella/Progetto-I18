package gUIInteface.exception;



public class WrongPassword extends MasterClassGUIException {
    private static final String TOSHOW = "The password is incorrect";
    private static final String TITLE = "Wrong Password";

    /**
     * This constructor is called if the username can be correct but not the password
     */
    public WrongPassword() {
        super(TITLE,TOSHOW);
    }

}
