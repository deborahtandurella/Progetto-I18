package Threads;

import Servizi.PrenotazioneBiglietti;
import Storico.Storico;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class PrenotazioneBigliettiThread extends Thread{
    private Storico log;
    private PrenotazioneBiglietti biglietti;
    private Socket client;
    private String received;
    private String tosend;
    private static final String errore = "Numero inserito non valido, riprovare";

    public PrenotazioneBigliettiThread(Storico log, Socket client, PrenotazioneBiglietti biglietti){
        this.client = client;
        this.biglietti = biglietti;
        this.log = log;
        System.out.println("thread");
        this.start();
    }

    public void run(){
        DataInputStream dis = null;
        DataOutputStream dos = null;

        String counter = "0";
        try{
            dis = new DataInputStream(client.getInputStream());
            dos = new DataOutputStream(client.getOutputStream());

            while (true){
                System.out.println("contatore "+counter);
                try{
                    dos.writeUTF(biglietti.getInfo().get(counter));
                }
                catch (NullPointerException e){
                    if(received.equals("8") && counter.equals("")){
                        counter = "0";
                    }else if(!received.equals("8")){
                        counter = counter.substring(0,counter.length()-1);
                    }
                    dos.writeUTF(errore + "\n" + biglietti.getInfo().get(counter));
                }
                log.aggiornastorico("Il server manda: " + biglietti.getInfo().get(counter), client);

                while(true){
                    received = dis.readUTF();
                    log.aggiornastorico("Il server ha ricevuto: " + received, client);
                    if (received.length() == 1){
                        break;
                    }
                    dos.writeUTF("Inserire un numero alla volta");
                }

                System.out.println("dato ricevuto "+received);

                if (received.equals("9")) {
                    this.client.close();
                    System.out.println("Fine chiamata");
                    break;
                }

                if (received.equals("8")){
                    counter = counter.substring(0,counter.length()-1);
                } else{
                    counter = counter.concat(received);
                }

                if (biglietti.getBiglietti().containsKey(counter)){
                    if (biglietti.prenotaBiglietti(counter)){
                        dos.writeUTF("Prenotazione effettuata con successo");
                        this.client.close();
                        break;
                    }
                    else{
                        dos.writeUTF("BIGLIETTI ESAURITI");
                    }
                }
            }
        }
        catch (EOFException | SocketException e){
            try{
                log.aggiornastorico("CHIAMATA INTERROTTA", client);
            }
            catch (IOException exc){
                exc.printStackTrace();
            }
        }
        catch (IOException e){
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
