import Servizi.InfoPoint;
import Servizi.PrenotazioneBiglietti;
import Storico.Storico;

import java.io.*;
import java.util.ArrayList;

public class CallCenter {
    private Storico log;
    private String nomeStorico;
    private ArrayList<InfoPoint> infoPoint;
    private String fileElencoInfoPoint;
    private ArrayList<String> elencoInfoPoint;
    private ArrayList<PrenotazioneBiglietti> biglietti;
    private String fileElencoPrenotazioneBiglietti;
    private ArrayList<String> elencoPrenotazioneBiglietti;

    public CallCenter(String fileElencoInfoPoint, String fileElencoPrenotazioneBiglietti, String nomeStorico) throws IOException {
        this.fileElencoInfoPoint = fileElencoInfoPoint;
        this.fileElencoPrenotazioneBiglietti = fileElencoPrenotazioneBiglietti;
        this.nomeStorico = nomeStorico;

        infoPoint = new ArrayList<>();
        biglietti = new ArrayList<>();
        this.elencoInfoPoint = new ArrayList<>();
        this.elencoPrenotazioneBiglietti = new ArrayList<>();
        inizializzaCallCenter();
        avviaServer();
    }

    private void inizializzaCallCenter() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileElencoInfoPoint));
        while (br.ready()) {
            String s = br.readLine();
            infoPoint.add(new InfoPoint(s));
            elencoInfoPoint.add(s);
        }

        br = new BufferedReader(new FileReader(fileElencoPrenotazioneBiglietti));
        while (br.ready()) {
            String s = br.readLine();
            biglietti.add(new PrenotazioneBiglietti(s, "dataBase"+s));
            elencoPrenotazioneBiglietti.add(s);
        }
        log = new Storico(nomeStorico);
    }

    private void avviaServer(){
        Server s = new Server(log, infoPoint, biglietti);
    }

    public void creaInfopoint(String nome) throws IOException {
        if (!elencoInfoPoint.contains(nome)) {
            infoPoint.add(new InfoPoint(nome));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileElencoInfoPoint, true));
            bw.newLine();
            bw.write(nome);
            bw.flush();
        }
        else{
            System.out.println("Servizio già presente");
        }
    }

    public void creaPrenotazioneBiglietti(String nome) throws IOException {
        if (!elencoPrenotazioneBiglietti.contains(nome)) {
            biglietti.add(new PrenotazioneBiglietti(nome,"database"+nome));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileElencoPrenotazioneBiglietti, true));
            bw.newLine();
            bw.write(nome);
            bw.flush();
        }
        else{
            System.out.println("Servizio già presente");
        }
    }
}
