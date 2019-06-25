package tester;

import gUIInteface.exception.*;

public class Tester {
    public static void main(String[] args) {
        ErrorRegisterLogin a=new ErrorRegisterLogin(ExceptionEnum.SHORT);
        a.setVisible(true);
    }
}
