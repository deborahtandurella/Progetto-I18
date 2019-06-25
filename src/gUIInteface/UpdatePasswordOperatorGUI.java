package gUIInteface;

import clientServer.MessageServer;
import clientServer.MessageType;
import clientServer.ServerInfo;
import gUIInteface.exception.EmptyField;
import gUIInteface.exception.ErrorRegisterLogin;
import gUIInteface.exception.ExceptionEnum;
import gUIInteface.exception.PasswordNotEqual;
import model.Operator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class UpdatePasswordOperatorGUI extends JFrame {
    private final String TITLE="UpdatePassword operator window";
    private final String PSW1LABEL="Insert your new password: ";
    private final String PSW2LABEL="Reinsert the new password: ";
    private final int WINDOWX1=600;
    private final int WINDOWY1=200;
    private final int WINDOWX2=400;
    private final int WINDOWY2=185;
    private final int PSW1LABELX1=10;
    private final int PSW1LABELY1=10;
    private final int PSW1LABELX2=200;
    private final int PSW1LABELY2=22;
    private final int PSW1TEXTX1=10;
    private final int PSW1TEXTY1=30;
    private final int PSW1TEXTX2=200;
    private final int PSW1TEXTY2=22;
    private final int PSW2LABELX1=10;
    private final int PSW2LABELY1=60;
    private final int PSW2LABELX2=200;
    private final int PSW2LABELY2=22;
    private final int PSW2TEXTX1=10;
    private final int PSW2TEXTY1=80;
    private final int PSW2TEXTX2=200;
    private final int PSW2TEXTY2=22;
    private final int BUTTONX1=150;
    private final int BUTTONY1=115;
    private final int BUTTONX2=75;
    private final int BUTTONY2=20;
    private String number;
    private String username;
    private String numCalling;
    private MenuOperationGUI menuOperationGUI;

    public UpdatePasswordOperatorGUI(MenuOperationGUI menuOperationGUI, String numCalling, String number, String username) {
        this.number = number;
        this.username = username;
        this.numCalling = numCalling;
        this.menuOperationGUI = menuOperationGUI;
        initialize();
    }

    /**
     * This method contains all the window settings
     */
    private void initialize() {
        this.setBounds(WINDOWX1,WINDOWY1,WINDOWX2,WINDOWY2);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle(TITLE);
        JLabel oldPswLabel = new JLabel(PSW1LABEL);
        oldPswLabel.setBounds(PSW1LABELX1,PSW1LABELY1,PSW1LABELX2,PSW1LABELY2);
        this.add(oldPswLabel);
        JTextField oldPswField = new JTextField("");
        oldPswField.setBounds(PSW1TEXTX1,PSW1TEXTY1,PSW1TEXTX2,PSW1TEXTY2);
        this.add(oldPswField);
        JLabel newPswLabel = new JLabel(PSW2LABEL);
        newPswLabel.setBounds(PSW2LABELX1,PSW2LABELY1,PSW2LABELX2,PSW2LABELY2);
        this.add(newPswLabel);
        JTextField newPswField = new JTextField("");
        newPswField.setBounds(PSW2TEXTX1,PSW2TEXTY1,PSW2TEXTX2,PSW2TEXTY2);
        this.add(newPswField);
        JButton button = new JButton("OK");
        button.setBounds(BUTTONX1,BUTTONY1,BUTTONX2,BUTTONY2);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operator operatorUpdated = null;
                Socket socket = null;
                if (!oldPswField.getText().equals("") && !newPswField.getText().equals("")) {
                    if (oldPswField.getText().trim().equals(newPswField.getText().trim())) {
                        if(isValid(oldPswField)) {
                            try {
                                socket = new Socket(ServerInfo.IP, ServerInfo.PORT);
                                ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
                                ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
                                os.writeObject(new MessageServer(MessageType.MODIFYPASSWORD, numCalling, new Operator(number, username, oldPswField.getText().trim())));
                                operatorUpdated = (Operator) is.readObject();
                                menuOperationGUI.updateOperator(operatorUpdated);
                            } catch (IOException | ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }
                            end();
                        }
                    }
                    else{
                        PasswordNotEqual error = new PasswordNotEqual();
                        error.setVisible(true);
                    }
                }
                else{
                    EmptyField emptyError = new EmptyField();
                    emptyError.setVisible(true);
                }
            }
        });
        this.add(button);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is used to dispose the window
     */
    private void end(){
        this.dispose();
    }

    /**
     * This method is used to check if the input contains numbers, uppercase and lowercase character and not contains the space character
     * @param toCheck
     * @return
     */
    private boolean isValid(JTextField toCheck) {
        boolean isNumber = false;
        boolean isUpper = false;
        boolean isLower = false;
        boolean isShort = false;
        boolean isSpace = false;
        String toCompare = toCheck.getText().trim();
        ErrorRegisterLogin errA;

        if (toCheck.getText().length() < 8) {
            isShort = true;
        }
        for (int i = 0; i < toCheck.getText().length(); i++) {
            if (Character.isUpperCase(toCompare.charAt(i))) {
                isUpper = true;
            }
            if (Character.isLowerCase(toCompare.charAt(i))) {
                isLower = true;
            }
            if (Character.isDigit(toCompare.charAt(i))) {
                isNumber = true;
            }
            if (Character.isSpaceChar(toCompare.charAt(i))) {
                isSpace = true;
            }
        }
        if (!isUpper) {
            errA = new ErrorRegisterLogin(ExceptionEnum.UPPER);
            errA.setVisible(true);
        }
        if (!isNumber) {
            errA = new ErrorRegisterLogin(ExceptionEnum.NUMBER);
            errA.setVisible(true);
        }
        if (!isLower) {
            errA = new ErrorRegisterLogin(ExceptionEnum.LOWER);
            errA.setVisible(true);
        }
        if (isSpace) {
            errA = new ErrorRegisterLogin(ExceptionEnum.SPACE);
            errA.setVisible(true);
        }
        if (isShort) {
            errA = new ErrorRegisterLogin(ExceptionEnum.SHORT);
            errA.setVisible(true);
        }
        return (isNumber && isLower && !isSpace && !isShort && isUpper);
    }

}
