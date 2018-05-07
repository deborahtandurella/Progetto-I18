package Threads;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

public class InfoPointThread extends Thread {
    private HashMap<String,String> infoPoint;
    private Socket client;
    private String received;
    private String tosend;
    private static final String errore = "Numero inserito non valido, riprovare";

    public InfoPointThread(Socket client, HashMap infoPoint){
        this.client = client;
        this.infoPoint = infoPoint;
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
                        dos.writeUTF(infoPoint.get(counter));
                    }
                    catch (NullPointerException e){
                        if(received.equals("8") && counter.equals("")){
                            counter = "0";
                        }else if(!received.equals("8")){
                            counter = counter.substring(0,counter.length()-1);
                        }
                        dos.writeUTF(errore + "\n" + infoPoint.get(counter));
                    }
                    received = dis.readUTF();
                    System.out.println("dato ricevuto "+received);

                    if (received.equals("9")) {
                        this.client.close();
                        System.out.println("Fine chiamata");
                        break;
                    }

                    dos.writeUTF(counter);

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
