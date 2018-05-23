package Servizi;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class InfoPoint {
    private String dataBase;
    private HashMap<String,String> infoPoint;
    private String numeroInfopoint;
    private static int counterInfoPoint = 0;

    public InfoPoint(String file) throws IOException {
        this.dataBase = "src\\Database\\"+file;
        infoPoint = new HashMap<String,String>();

        inizializzaInfoPoint();
        caricaDati();
    }

    private void inizializzaInfoPoint(){
        numeroInfopoint = Integer.toString(counterInfoPoint);
        counterInfoPoint++;
        try {
            File file = new File(dataBase);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void aggiungiInfo(String posizione, String s){
        infoPoint.put(posizione,s);
    }

    private void caricaDati() throws IOException {
            BufferedReader br = new BufferedReader(new FileReader(dataBase));
            while (br.ready()) {
                String[] s = br.readLine().split("\t");
                String string = s[1];
                for (int i = 2; i < s.length; i++) {
                    string = string + "\n" + s[i];
                }
                infoPoint.put(s[0], string);
            }
    }

    public void salvaDati() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(dataBase));

        for(Map.Entry<String,String>entry:infoPoint.entrySet()){
            bw.write(entry.getKey()+"\t"+entry.getValue().replace("\n","\t")+"\n");
            bw.flush();
        }
    }

    public HashMap<String, String> getInfoPoint() {
        return infoPoint;
    }

    public String getNumeroInfopoint() {
        return numeroInfopoint;
    }
}
