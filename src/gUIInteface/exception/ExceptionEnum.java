package gUIInteface.exception;

/**
 * This enum contains the names of all the exceptions handled in ErrorRegisterLogin class
 */
public enum ExceptionEnum {
    SHORT("Minimum length of 8 is required"),
    NUMBER("The password must contain a number"),
    UPPER("The password must contain an uppercase letter"),
    LOWER("The password must contain a lowercase letter"),
    SPACE("The space character is not allowed");

    private String labelToShow;

    /**
     * This method returns the String associated to the enumeration
     * @return labelToShow
     */
    public String getValue(){
        return labelToShow;
    }
    private ExceptionEnum(String labelToShow){
        this.labelToShow = labelToShow;
    }

}
