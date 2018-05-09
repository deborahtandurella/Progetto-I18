
package com.company;
import java.io.*;
import java.util.*;

public class ReadFile {

    public static String lettura() throws IOException{
        String s = "";
        //DataBase db = new DataBase();
        FileReader file = new FileReader("C:\\Users\\edjbr\\Documents\\Universita\\Prog_SW java\\CallCenter JAVA\\src\\com\\company\\DataBase.txt");
        BufferedReader in = new BufferedReader(file);

        if (in.ready()){
            s = in.readLine();
        }
        in.close();
        return s;
    }

}
