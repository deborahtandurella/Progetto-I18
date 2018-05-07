package Servizi;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class InfoPoint {
    private String dataBase;
    private HashMap<String,String> infoPoint;

    public InfoPoint(String file) throws IOException {
        this.dataBase = file;
        infoPoint = new HashMap<String,String>();

        caricaDati();
    }

    public void aggiungiInfo(String posizione, String s){
        infoPoint.put(posizione,s);
    }

    private void caricaDati() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(dataBase));
        while (br.ready()){
            String[] s = br.readLine().split("\t");
            String string = s[1];
            //System.out.println(string);
            for(int i=2;i < s.length;i++){
                string = string + "\n" + s[i];
            }
            //System.out.println(s[0]);
            infoPoint.put(s[0],string);
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
}
