import Servizi.InfoPoint;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server {
    private ArrayList<InfoPoint> infoPoint;
    private String numeroChiamato;

    public Server(ArrayList infoPoint) {
        this.infoPoint = infoPoint;
        start();
    }

    private void start(){
        try{
            //InetAddress ip = InetAddress.getByName("localhost");
            DataInputStream dis = null;
            DataOutputStream dos = null;
            ServerSocket server = new ServerSocket(55556,50);
            while(true){
                Socket client = server.accept();

                System.out.println("Connessione effettuata da: "+ client);

                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());

                //System.out.println(client.getInputStream());

                numeroChiamato = dis.readUTF();
                System.out.println("attesa numero");

                for(InfoPoint infoPoint: infoPoint){
                    if (infoPoint.getNumeroInfopoint().equals(numeroChiamato)){
                        Threads.InfoPointThread newThread = new Threads.InfoPointThread(client,this.infoPoint.get(Integer.parseInt(numeroChiamato)).getInfoPoint());
                    }
                }
                System.out.println("thread lanciato");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
