import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login1 extends JFrame implements ActionListener {
    public static final int WIDTH=1000;
    public static final int HEIGHT=300;
    public static final Color c=Color.CYAN;
    public GUIOp a;
    public JTextField user;
    public JPasswordField psw;
    // le variabili dopo sono fatte per il confronto
    String op;
    String userc;


    public Login1(){
        super();
        setTitle("Login");
        setSize(WIDTH,HEIGHT);
        setLayout(new GridLayout(3,1));
        Container colorPanel1= getContentPane();
        colorPanel1.setBackground(c);

        JPanel empty=new JPanel();
        empty.setBackground(c);
        add(empty);


        JPanel jp2=new JPanel();
        jp2.setBackground(c);
        JLabel label2=new JLabel("Username : \n");
        user=new JTextField("",20);
        jp2.add(label2);
        jp2.add(user);
        JLabel label3=new JLabel("Password : \n");
        psw=new JPasswordField("",20);
        jp2.add(label3);
        jp2.add(psw);
        add(jp2);

        JPanel jp3=new JPanel();
        JButton Confirm =new JButton("Confirm");
        Confirm.addActionListener(this);
        JButton Back= new JButton("Back");
        Back.addActionListener(this);
        jp3.add(Confirm);
        jp3.add(Back);
        jp3.setBackground(c);
        add(jp3);

        WindowCloser a2=new WindowCloser();
        addWindowListener(a2);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Confirm")){
            userc=user.getText();
            op= String.valueOf(psw.getPassword());
            System.out.print("user : "+userc+" password : ");// da togliere;
            System.out.println(op);
        }
        if(e.getActionCommand().equals("Back")){
            this.setVisible(false);
            a=new GUIOp();
            a.setVisible(true);
        }
    }


}
