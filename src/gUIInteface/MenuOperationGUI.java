package gUIInteface;

import clientServer.MessageServer;
import clientServer.MessageType;
import clientServer.ServerInfo;
import dataHistory.DataWriterClient;
import model.Operator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MenuOperationGUI extends JFrame {
    private final String TITLE = "Menu operations window";
    private final int WINDOWX1 = 600;
    private final int WINDOWY1 = 200;
    private final int WINDOWX2 = 400;
    private final int WINDOWY2 = 300;

    private final String DELETEOPERATIONBUTTONPRESSED = "The operator pressed the Delete Operation button";
    private final String ADDOPERATIONBUTTONPRESSED = "The operator pressed the Delete Operation button";
    private final String CHANGEIDOPERATIONBUTTONPRESSED = "The operator pressed the Change ID Operation button";
    private final String CHANGETEXTOPERATIONBUTTONPRESSED = "The operator pressed the Change Text Operation button";
    private final String DELETEOPERATORBUTTONPRESSED = "The operator pressed the Delete Operator button";
    private final String CHANGEUSERNAMEOPERATORBUTTONPRESSED = "The operator pressed the Change Username button";
    private final String CHANGEPASSWORDOPERATORBUTTONPRESSED = "The operator pressed the Change Password button";
    private final String LOGOUTBUTTONPRESSED = "The operator pressed the Logout button";
    private final int DELETEONX1=10;
    private final int DELETEONY1=10;
    private final int BUTTONX=170;
    private final int BUTTONY=40;
    private final int ADDONX1=200;
    private final int ADDONY1=10;
    private final int CHANGEIDX1=10;
    private final int CHANGEIDY1=60;
    private final int CHANGETEXTX1=200;
    private final int CHANGETEXTY1=60;
    private final int DELETEORX1=10;
    private final int DELETEORY1=110;
    private final int CHANGEUSERNAMEX1=200;
    private final int CHANGEUSERNAMEY1=110;
    private final int CHANGEPASSWORDX1=10;
    private final int CHANGEPASSWORDY1=160;
    private final int LOGOUTX1=200;
    private final int LOGOUTY1=160;
    private Operator operator;
    private String numberCalling;
    private DataWriterClient dataWriter;
    private CallGUI callGUI;

    public MenuOperationGUI(CallGUI callGUI, String numberCalling, Operator operator){
        this.operator = operator;
        this.numberCalling = numberCalling;
        this.callGUI=callGUI;
        callGUI.getShowOptio().setVisible(false);
        dataWriter = new DataWriterClient(numberCalling);
        updateStatus();

        this.setBounds(WINDOWX1, WINDOWY1, WINDOWX2, WINDOWY2);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle(TITLE);

        JButton delOpBtn = new JButton("Delete Operation");
        delOpBtn.setBounds(DELETEONX1,DELETEONY1,BUTTONX,BUTTONY);
        delOpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteOperationGUI deleteOperation = new DeleteOperationGUI(numberCalling, operator.getNumber());
                deleteOperation.setVisible(true);
                dataWriter.updateHistory(DELETEOPERATIONBUTTONPRESSED);
            }
        });
        this.add(delOpBtn);

        JButton addOpBtn = new JButton("Add Operation");
        addOpBtn.setBounds(ADDONX1,ADDONY1,BUTTONX,BUTTONY);
        addOpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertOperationGUI insertOperation = new InsertOperationGUI(numberCalling,operator.getNumber());
                insertOperation.setVisible(true);
                dataWriter.updateHistory(ADDOPERATIONBUTTONPRESSED);
            }
        });
        this.add(addOpBtn);

        JButton changeIdOpBtn = new JButton("Change ID operation");
        changeIdOpBtn.setBounds(CHANGEIDX1,CHANGEIDY1,BUTTONX,BUTTONY);
        changeIdOpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateIDOperationGUI updateOperationId = new UpdateIDOperationGUI(numberCalling, operator.getNumber());
                updateOperationId.setVisible(true);
                dataWriter.updateHistory(CHANGEIDOPERATIONBUTTONPRESSED);
            }
        });
        this.add(changeIdOpBtn);

        JButton changeTextOpBtn = new JButton("Change Text operation");
        changeTextOpBtn.setBounds(CHANGETEXTX1,CHANGETEXTY1,BUTTONX,BUTTONY);
        changeTextOpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateTextOperationGUI updateOperationText = new UpdateTextOperationGUI(numberCalling, operator.getNumber());
                updateOperationText.setVisible(true);
                dataWriter.updateHistory(CHANGETEXTOPERATIONBUTTONPRESSED);
            }
        });
        this.add(changeTextOpBtn);


        JButton delAccntBtn = new JButton("Delete your account");
        delAccntBtn.setBounds(DELETEORX1,DELETEORY1,BUTTONX,BUTTONY);
        delAccntBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteOperatorGUI deleteOperator = new DeleteOperatorGUI(getFrame(),numberCalling, operator);
                deleteOperator.setVisible(true);
                dataWriter.updateHistory(DELETEOPERATORBUTTONPRESSED);
            }
        });
        this.add(delAccntBtn);


        JButton changeNameBtn = new JButton("Change your username");
        changeNameBtn.setBounds(CHANGEUSERNAMEX1,CHANGEUSERNAMEY1,BUTTONX,BUTTONY);
        changeNameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateUsernameOperatorGUI updateOperatorUsername= new UpdateUsernameOperatorGUI(getFrame(), numberCalling, getOperator().getNumber(), getOperator().getUsername());
                updateOperatorUsername.setVisible(true);
                dataWriter.updateHistory(CHANGEUSERNAMEOPERATORBUTTONPRESSED);
            }
        });
        this.add(changeNameBtn);

        JButton changePswdBtn = new JButton("Change your password");
        changePswdBtn.setBounds(CHANGEPASSWORDX1,CHANGEPASSWORDY1,BUTTONX,BUTTONY);
        changePswdBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdatePasswordOperatorGUI updateOperatorPassword = new UpdatePasswordOperatorGUI(getFrame(), numberCalling, getOperator().getNumber(), getOperator().getUsername());
                updateOperatorPassword.setVisible(true);
                dataWriter.updateHistory(CHANGEPASSWORDOPERATORBUTTONPRESSED);
            }
        });
        this.add(changePswdBtn);
        JButton logOutBtn = new JButton("Logout");
        logOutBtn.setBounds(LOGOUTX1,LOGOUTY1,BUTTONX,BUTTONY);
        logOutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataWriter.updateHistory(LOGOUTBUTTONPRESSED);
                close();
            }
        });
        this.add(logOutBtn);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) { }

            @Override
            public void windowClosing(WindowEvent e) { }

            @Override
            public void windowClosed(WindowEvent e) {
                updateStatus();
                callGUI.setVisible(false);
                callGUI.setVisible(true);
                callGUI.getShowOptio().updateOptions();
                callGUI.toFront();
                callGUI.requestFocus();
                callGUI.getShowOptio().setVisible(true);
            }

            @Override
            public void windowIconified(WindowEvent e) { }

            @Override
            public void windowDeiconified(WindowEvent e) { }

            @Override
            public void windowActivated(WindowEvent e) { }

            @Override
            public void windowDeactivated(WindowEvent e) { }
        });

    }

    /**
     * This method change the status (logged in or logged out) of a defined operator
     */
    public void updateStatus() {
        Socket socket = null;
        this.operator.setLoggedIn(!this.operator.isLoggedIn());
        try {
            socket = new Socket(ServerInfo.IP, ServerInfo.PORT);
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            os.writeObject(new MessageServer(MessageType.LOGGED, numberCalling, operator));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method dispose the window
     */
    private void close() {
        this.dispose();
    }

    /**
     * This method change the actual operator
     * @param operator
     */
    public void updateOperator(Operator operator) {
        this.operator=operator;
    }

    /**
     * This method returns the actual window
     * @return this
     */
    private MenuOperationGUI getFrame() {
        return this;
    }

    /**
     * This method returns the actual operator
     * @return
     */
    private Operator getOperator(){
        return this.operator;
    }

}
