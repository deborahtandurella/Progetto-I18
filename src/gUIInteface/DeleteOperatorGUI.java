package gUIInteface;

import clientServer.MessageServer;
import clientServer.MessageType;
import clientServer.ServerInfo;
import model.Operator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * This class is used to delete an operator logged in
 */
public class DeleteOperatorGUI extends JFrame {
    private final String TITLE = "Delete operator window";
    private final String MESSAGE = "Are you sure to delete this account?";
    private final String BUTTON = "OK";
    private final String CANCEL = "Cancel";
    private final int WINDOWX1 = 600;
    private final int WINDOWY1 = 200;
    private final int WINDOWX2 = 350;
    private final int WINDOWY2 = 150;
    private final int LABELX1 = 10;
    private final int LABELY1 = 10;
    private final int LABELX2 = 300;
    private final int LABELY2 = 25;
    private final int BUTTONX1 = 50;
    private final int BUTTONY1 = 60;
    private final int BUTTONX2 = 75;
    private final int BUTTONY2 = 30;

    private Operator operator = null;
    private MenuOperationGUI menuOperationGUI = null;
    private String numCalling;

    public DeleteOperatorGUI(MenuOperationGUI menuOperationGUI, String numCalling, Operator operator) {
        this.operator = operator;
        this.menuOperationGUI = menuOperationGUI;
        this.numCalling = numCalling;
        initialize();
    }

    /**
     * This method contains all the window settings
     */
    private void initialize() {
        this.setBounds(WINDOWX1, WINDOWY1, WINDOWX2, WINDOWY2);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle(TITLE);
        JLabel msgLabel=new JLabel(MESSAGE);
        msgLabel.setBounds(LABELX1, LABELY1, LABELX2, LABELY2);
        this.add(msgLabel);
        JButton button=new JButton(BUTTON);
        button.setBounds(BUTTONX1, BUTTONY1, BUTTONX2, BUTTONY2);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Socket socket = null;
                try {
                    socket = new Socket(ServerInfo.IP, ServerInfo.PORT);
                    ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
                    os.writeObject(new MessageServer(MessageType.DELETEOPERATOR, numCalling, operator.getNumber(), operator.getUsername()));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                end();
                menuOperationGUI.dispose();
            }
        });
        this.add(button);
        JButton cancel=new JButton(CANCEL);
        cancel.setBounds(BUTTONX1 + 80, BUTTONY1, BUTTONX2, BUTTONY2);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                end();
            }
        });
        this.add(cancel);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method close the window
     */
    private void end(){
        this.dispose();
    }
}
