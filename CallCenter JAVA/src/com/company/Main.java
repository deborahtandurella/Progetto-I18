package com.company;
import javax.swing.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException{

        Phone cal = new Phone();

        //Chiude la finestra con la X.
        cal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cal.pack();
        cal.setVisible(true);

    }
}
