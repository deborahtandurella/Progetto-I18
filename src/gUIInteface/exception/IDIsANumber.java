package gUIInteface.exception;

public class IDIsANumber extends MasterClassGUIException {
    private static final String TOSHOW = "The id must be a number";
    private static final String TITLE = "Error ID";

    /**
     * This constructor is called if a field is not numeric
     */
    public IDIsANumber() {
        super(TITLE,TOSHOW);
    }

}
