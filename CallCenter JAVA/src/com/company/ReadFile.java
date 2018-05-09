package com.company;

import java.io.*;
import java.util.*;

public class ReadFile {

    public static String lettura() throws IOException{
        String s = "";

        FileReader file = new FileReader("C:\\Users\\edjbr\\Documents\\GitHub\\Progetto-I18\\CallCenter JAVA\\src\\com\\company\\DataBase.txt");
        BufferedReader in = new BufferedReader(file);

        String line;

        //Questo prende il file.txt come un blocco unico e poi lo separa riga per riga
        while((line = in.readLine()) != null) {
            s += line + "\n";
        }

        /*
        if (in.ready()){
            s = in.readLine();
        }*/

        in.close();
        return s;
    }
}
