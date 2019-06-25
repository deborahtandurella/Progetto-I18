package gUIInteface.exception;

public class ErrorCall extends MasterClassGUIException {
    private static final String TOSHOW = "The number must be longer than 2 digits and shorter than 11 digits";
    private static final String TITLE = "Error";

    /**
     * This constructor is called if an input is too short
     */
    public ErrorCall(){
        super(TITLE,TOSHOW);
    }

}
