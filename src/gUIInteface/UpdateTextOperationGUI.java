package gUIInteface;

import clientServer.MessageServer;
import clientServer.MessageType;
import clientServer.ServerInfo;
import gUIInteface.exception.EmptyField;
import gUIInteface.exception.IDIsANumber;
import model.Operation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * This class is used to receive the inputs to change the textof an operation
 */
public class UpdateTextOperationGUI extends JFrame {
    private final int WINDOWX1=600;
    private final int WINDOWY1=200;
    private final int WINDOWX2=345;
    private final int WINDOWY2=180;
    private final int LABELIDX1=10;
    private final int LABELIDY1=10;
    private final int LABELIDX2=300;
    private final int LABELIDY2=25;
    private final int TEXTIDX1=10;
    private final int TEXTIDY1=30;
    private final int TEXTIDX2=200;
    private final int TEXTIDY2=25;
    private final int LABELTEXTX1=10;
    private final int LABELTEXTY1=60;
    private final int LABELTEXTX2=300;
    private final int LABELTEXTY2=25;
    private final int TEXTTEXTX1=10;
    private final int TEXTTEXTY1=80;
    private final int TEXTTEXTX2=200;
    private final int TEXTTEXTY2=25;
    private final int BUTTONX1=130;
    private final int BUTTONY1=113;
    private final int BUTTONX2=60;
    private final int BUTTONY2=20;
    private final String TITLE="UpdateText operation window";
    private final String LABELID="Insert the id of the operation to modify: ";
    private final String LABELTEXT="Insert the new text for the operation: ";
    private String number;
    private String numCalling;

    public UpdateTextOperationGUI(String numCalling, String number) {
        this.number = number;
        this.numCalling = numCalling;
        initialize();
    }

    /**
     * This method contains all the window settings
     */
    private void initialize(){
        this.setBounds(WINDOWX1,WINDOWY1,WINDOWX2,WINDOWY2);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle(TITLE);
        JLabel idLabel = new JLabel(LABELID);
        idLabel.setBounds(LABELIDX1,LABELIDY1,LABELIDX2,LABELIDY2);
        this.add(idLabel);
        JTextField idField = new JTextField("");
        idField.setBounds(TEXTIDX1,TEXTIDY1,TEXTIDX2,TEXTIDY2);
        this.add(idField);
        JLabel newTextLabel = new JLabel(LABELTEXT);
        newTextLabel.setBounds(LABELTEXTX1,LABELTEXTY1,LABELTEXTX2,LABELTEXTY2);
        this.add(newTextLabel);
        JTextField newTextField = new JTextField("");
        newTextField.setBounds(TEXTTEXTX1,TEXTTEXTY1,TEXTTEXTX2,TEXTTEXTY2);
        this.add(newTextField);
        JButton button = new JButton("OK");
        button.setBounds(BUTTONX1,BUTTONY1,BUTTONX2,BUTTONY2);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Socket socket = null;
                if (!idField.getText().equals("") && !newTextField.getText().equals("")) {
                    if (isValid(idField.getText())) {
                        try {
                            socket = new Socket(ServerInfo.IP, ServerInfo.PORT);
                            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
                            os.writeObject(new MessageServer(MessageType.MODIFYTEXTOPERATION, numCalling, new Operation(idField.getText().trim(), number, newTextField.getText().trim())));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        end();
                    }
                    else{
                        IDIsANumber errorID = new IDIsANumber();
                        errorID.setVisible(true);
                    }
                }
                else{
                    EmptyField emptyField = new EmptyField();
                    emptyField.setVisible(true);
                }
            }
        });
        this.add(button);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method checks if the input is composed only by numbers
     * @param iDToCheck
     * @return
     */
    private boolean isValid(String iDToCheck){
        for(int i=0;i<iDToCheck.length();i++){
            if(!Character.isDigit(iDToCheck.charAt(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * This method close the window
     */
    private void end(){
        this.dispose();
    }

}
