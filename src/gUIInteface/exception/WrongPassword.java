package gUIInteface.exception;



public class WrongPassword extends MasterClassGUIException {
    private static final String TOSHOW = "The password is incorrect";
    private static final String TITLE = "Wrong Password";

    public WrongPassword() {
        super(TITLE,TOSHOW);
    }

}
