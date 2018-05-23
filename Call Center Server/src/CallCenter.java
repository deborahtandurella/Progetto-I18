import Servizi.InfoPoint;

import java.io.*;
import java.util.ArrayList;

public class CallCenter {
    private ArrayList<InfoPoint> infoPoint;
    private String fileElencoInfoPoint;
    private ArrayList<String> elencoInfoPoint;

    public CallCenter(String file) throws IOException {
        fileElencoInfoPoint = file;
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
    }

    private void avviaServer(){
        Server s = new Server(infoPoint);
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
