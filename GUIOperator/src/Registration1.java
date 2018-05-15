import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Registration1 extends JFrame {

    public static final int WIDTH=400;
    public static final int HEIGHT=250;
    public static final Color c=Color.CYAN;
    public GUIOp guiop;


    public JTextField number;
    public JPasswordField pass;
    public JPasswordField repass;
    public JTextField id;

    public String num;
    public String idn;
    public String psw1;
    public String repsw;

    public Registration1(){
        super();
        setTitle("Operator Registration");
        setSize(WIDTH,HEIGHT);
        setLayout(new BorderLayout());
        Container colorPanel1= getContentPane();
        colorPanel1.setBackground(Color.cyan);
        setLayout(new GridLayout(6,1));


        JLabel label1=new JLabel("New user? enter your credentials\n");
         add(label1,BorderLayout.CENTER);

        JLabel label2=new JLabel("Phone Number:");
        JTextField number =new JTextField("",12);
        JPanel jp1=new JPanel();
        jp1.add(label2,BorderLayout.CENTER);
        jp1.add(number,BorderLayout.EAST);
        jp1.setBackground(c);
         add(jp1,BorderLayout.EAST);

        JLabel label3=new JLabel("User ID");
        JTextField id =new JTextField("",12);
        JPanel jp2=new JPanel();
        jp2.add(label3,BorderLayout.CENTER);
        jp2.add(id,BorderLayout.EAST);
        jp2.setBackground(c);
         add(jp2,BorderLayout.EAST);

        JLabel label4=new JLabel("Password");
        JPasswordField pass =new JPasswordField("",12);
        JPanel jp3=new JPanel();
        jp3.add(label4,BorderLayout.CENTER);
        jp3.add(pass,BorderLayout.EAST);
        jp3.setBackground(c);
         add(jp3,BorderLayout.EAST);

        JLabel label5=new JLabel("Repeat Password");
        JPasswordField repass =new JPasswordField("",12);
        JPanel jp4=new JPanel();
        jp4.add(label5,BorderLayout.CENTER);
        jp4.add(repass,BorderLayout.EAST);
        jp4.setBackground(c);
         add(jp4,BorderLayout.EAST);

        JPanel jp5=new JPanel();
        JButton Confirm =new JButton("Confirm");
        Confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = number.getText();
                idn = id.getText();
                psw1 = String.valueOf(pass.getPassword());
                repsw = String.valueOf(repass.getPassword());

                System.out.println("numero: " + num + " id : " + idn + "\npassword" + psw1 + " repass: " + repsw);

            }
        });

        JButton Back= new JButton("Back");
        Back.addActionListener(e -> {
            this.setVisible(false);
            guiop = new GUIOp();
            guiop.setVisible(true);
        });
        //Back.addActionListener(this);
        jp5.add(Confirm);
        jp5.add(Back);
        jp5.setBackground(c);
         add(jp5);

        WindowCloser a3=new WindowCloser();
        addWindowListener(a3);
    }


}
