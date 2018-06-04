package Servizi;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class InfoPoint extends Servizio{
    //private String infoName;
    //private HashMap<String,String> info;
    //private String numeroDelServizio;
    //private static int counter = 0;

    public InfoPoint(String infoName) throws IOException {
        this.infoName = "src\\Database\\"+infoName;
        info = new HashMap<String,String>();

        inizializzaServizio();
        caricaInfo();
    }

    private void inizializzaServizio(){
        numeroDelServizio = Integer.toString(counter);
        counter++;
        try {
            File file = new File(infoName);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void aggiungiInfo(String posizione, String s){
        info.put(posizione,s);
    }

    /*private void caricaDati() throws IOException {
            BufferedReader br = new BufferedReader(new FileReader(infoName));
            while (br.ready()) {
                String[] s = br.readLine().split("\t");
                String string = s[1];
                for (int i = 2; i < s.length; i++) {
                    string = string + "\n" + s[i];
                }
                info.put(s[0], string);
            }
    }*/

    /*public void salvaDati() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(infoName));

        for(Map.Entry<String,String>entry: info.entrySet()){
            bw.write(entry.getKey()+"\t"+entry.getValue().replace("\n","\t")+"\n");
            bw.flush();
        }
    }*/

    public HashMap<String, String> getInfoPoint() {
        return info;
    }
}
