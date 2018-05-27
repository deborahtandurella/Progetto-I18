import Servizi.InfoPoint;
import Storico.Storico;

import java.io.*;
import java.util.ArrayList;

public class CallCenter {
    private Storico log;
    private String nomeStorico;
    private ArrayList<InfoPoint> infoPoint;
    private String fileElencoInfoPoint;
    private ArrayList<String> elencoInfoPoint;

    public CallCenter(String file, String nomeStorico) throws IOException {
        fileElencoInfoPoint = file;
        this.nomeStorico = nomeStorico;
        infoPoint = new ArrayList<>();
        elencoInfoPoint = new ArrayList<>();
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
        log = new Storico(nomeStorico);
    }

    private void avviaServer(){
        Server s = new Server(infoPoint,log);
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
}
