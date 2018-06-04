package Threads;

import Storico.Storico;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

public class InfoPointThread extends Thread {
    private Storico log;
    private HashMap<String,String> infoPoint;
    private Socket client;
    private String received;
    private String tosend;
    private static final String errore = "Numero inserito non valido, riprovare";

    public InfoPointThread(Storico log, Socket client, HashMap infoPoint){
        this.client = client;
        this.infoPoint = infoPoint;
        this.log = log;
        System.out.println("thread");
        this.start();
    }

    public void run(){
        DataInputStream dis = null;
        DataOutputStream dos = null;

        //int counter = 0;
        String counter = "0";
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());

                while(true) {
                    System.out.println("contatore "+counter);
                    try{
                        System.out.println("OK");
                        dos.writeUTF(infoPoint.get(counter));
                        System.out.println("OK");
                    }
                    catch (NullPointerException e){
                        System.out.println("OK");
                        if(received.equals("8") && counter.equals("")){
                            counter = "0";
                        }else if(!received.equals("8")){
                            counter = counter.substring(0,counter.length()-1);
                        }
                        dos.writeUTF(errore + "\n" + infoPoint.get(counter));
                    }
                    log.aggiornastorico("Il server manda: " + infoPoint.get(counter), client);

                    //POTREBBE DIVENTARE UN METODO
                    //-----------------------------------------------
                    while(true){
                        received = dis.readUTF();
                        log.aggiornastorico("Il server ha ricevuto: " + received, client);
                        if (received.length() == 1){
                            break;
                        }
                            dos.writeUTF("Inserire un numero alla volta");
                    }
                    //-----------------------------------------------

                    System.out.println("dato ricevuto "+received);

                    if (received.equals("9")) {
                        this.client.close();
                        System.out.println("Fine chiamata");
                        break;
                    }

                    //dos.writeUTF(counter);

                    if (received.equals("8")){
                        counter = counter.substring(0,counter.length()-1);
                    } else{
                        counter = counter.concat(received);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    dis.close();
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
}
