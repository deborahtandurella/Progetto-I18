import Servizi.InfoPoint;
import Storico.Storico;

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
    private Storico log;

    public Server(ArrayList infoPoint, Storico log) {
        this.infoPoint = infoPoint;
        this.log = log;
        start();
    }

    private void start(){
        try{
            //InetAddress ip = InetAddress.getByName("localhost");
            DataInputStream dis = null;
            DataOutputStream dos = null;
            ServerSocket server = new ServerSocket(55556,50);
            log.aggiornastorico("SERVER AVVIATO");
            while(true){
                Socket client = server.accept();

                System.out.println("Connessione effettuata da: "+ client);
                log.aggiornastorico("Connessione effettuata da: "+ client);

                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());

                //System.out.println(client.getInputStream());

                numeroChiamato = dis.readUTF();
                System.out.println("attesa numero");

                for(InfoPoint infoPoint: infoPoint){
                    if (infoPoint.getNumeroInfopoint().equals(numeroChiamato)){
                        Threads.InfoPointThread newThread = new Threads.InfoPointThread(log,client,this.infoPoint.get(Integer.parseInt(numeroChiamato)).getInfoPoint());
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
