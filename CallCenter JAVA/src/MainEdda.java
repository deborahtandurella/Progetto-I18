import com.company.Phone;
import com.company.PhoneEdda;

import javax.swing.*;
import java.io.IOException;

public class MainEdda {

    public static void main(String[] args) {
        //creiamo un nuovo oggetto JFrame per cambiare le dimensioni e la posizione dell'interfaccia
       //JFrame fEdda = new JFrame();
        PhoneEdda phEdda = new PhoneEdda();
        //fEdda.add(phEdda.getMainPanelEdda());
        phEdda.setTitle("CALL CENTER");
        phEdda.setBounds(200, 100, 800, 600);
       phEdda.setVisible(true);

       // phEdda.pack();

    }
}
