import Servizi.InfoPoint;
import Servizi.PrenotazioneBiglietti;
import Storico.Storico;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class Server {
    private ArrayList<InfoPoint> infoPoint;
    private ArrayList<PrenotazioneBiglietti> prenotazioneBiglietti;
    private String numeroChiamato;
    private Storico log;

    public Server(Storico log, ArrayList infoPoint, ArrayList prenotazioneBiglietti) {
        this.infoPoint = infoPoint;
        this.prenotazioneBiglietti = prenotazioneBiglietti;
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

                for (InfoPoint infoPoint : infoPoint) {
                    if (infoPoint.getNumeroDelServizio().equals(numeroChiamato)) {
                        Threads.InfoPointThread newThread = new Threads.InfoPointThread(log, client, this.infoPoint.get(Integer.parseInt(numeroChiamato)).getInfoPoint());
                        System.out.println("thread1 lanciato");
                    }
                }
                for (PrenotazioneBiglietti biglietti : prenotazioneBiglietti){
                    if (biglietti.getNumeroDelServizio().equals(numeroChiamato)){
                        Threads.PrenotazioneBigliettiThread newThread = new Threads.PrenotazioneBigliettiThread(log,client,biglietti);
                        System.out.println("thread2 lanciato");
                    }
                }

            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
