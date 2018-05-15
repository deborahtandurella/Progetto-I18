import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GUIOp extends JFrame implements ActionListener{
    public static final int WIDTH=400;
    public static final int HEIGHT=200;
    public Registration1 reggui;
    public Login1 logingui;

    public  GUIOp (){
        super();
        setTitle("Operator Access");
        setSize(WIDTH,HEIGHT);
        setLayout(new BorderLayout());
        Container colorPanel1= getContentPane();
        colorPanel1.setBackground(Color.cyan);


        JLabel label1=new JLabel("Are you a new user or you are already registered ?");
        add(label1,BorderLayout.CENTER);

        JPanel pulsanti= new JPanel();
        pulsanti.setBackground(Color.CYAN);
        JButton register=new JButton("Register");
        register.addActionListener(this);
        JButton login=new JButton("Login");
        login.addActionListener(this);
        pulsanti.add(register, BorderLayout.WEST);
        pulsanti.add(login,BorderLayout.EAST);
        add(pulsanti, BorderLayout.SOUTH);

        WindowCloser a1=new WindowCloser();
        addWindowListener(a1);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Register")){
            this.setVisible(false);
            reggui=new Registration1();
            reggui.setVisible(true);
        }
        if(e.getActionCommand().equals("Login")){
            this.setVisible(false);
            logingui=new Login1();
            logingui.setVisible(true);

        }
    }

}
