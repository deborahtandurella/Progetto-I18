package gUIInteface.exception;

public class EmptyField extends MasterClassGUIException {
    private static final String TOSHOW="All the fields must be filled";
    private static final String TITLE="Empty field";

    /**
     * This constructor is called if a field is empty
     */
    public EmptyField() {
        super(TITLE,TOSHOW);
    }

}
