package gUIInteface.exception;

/**
 * This class is used if an input is too short
 */
public class ErrorCall extends MasterClassGUIException {
    private static final String TOSHOW = "The number must be longer than 2 digits and shorter than 11 digits";
    private static final String TITLE = "Error";


    public ErrorCall(){
        super(TITLE,TOSHOW);
    }

}
