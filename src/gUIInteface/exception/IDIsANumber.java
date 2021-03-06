package gUIInteface.exception;

/**
 * This class is used if a field is not numeric
 */
public class IDIsANumber extends MasterClassGUIException {
    private static final String TOSHOW = "The id must be a number";
    private static final String TITLE = "Error ID";


    public IDIsANumber() {
        super(TITLE,TOSHOW);
    }

}
