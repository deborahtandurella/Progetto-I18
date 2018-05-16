package com.company;
import javax.swing.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException{
        JFrame f = new JFrame();
        f.setTitle("CALL CENTER");
        f.setBounds(200, 100, 800, 600);
        f.setVisible(true);
        Phone cal = new Phone();
        f.add(cal.getMainPanel());
        //Chiude la finestra con la X.
        cal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cal.pack();
        f.pack();


    }
}
