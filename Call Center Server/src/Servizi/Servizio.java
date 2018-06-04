package Servizi;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public abstract class Servizio {
    protected String infoName;
    protected HashMap<String,String> info;
    protected String numeroDelServizio;
    protected static int counter = 0;

    //DISCUTERE SUL FATTO CHE DICHIARARE QUESTO METODO (COMUNE A TUTTE LE SOTTOCLASSI DI "SERVIZIO") NELLA
    //SUPERCLASSE, CON MODIFICATORE PROTECTED, DIMINUISCA LA ROBUSTEZZA DEL MIO PROGRAMMA. INFATTI SAREBBE
    //POSSIBILE RICHIAMARE QUESTO MOETODO IN UNA CLASSE NON APPARTENENTE AL PACKAGE "SERVIZIO" ATTRAVERSO IL
    //COMANDO "SUPER", AUMENTANDO COSì IL CONTATORE DICHIARATO STATICO.
    //
    //NON FACENDOLO MI COSTRINGE PERò AD AVERE CODICE DUPLICATO NELLE SOTTOCLASSI.

    /*protected void inizializzaServizio(){
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
    }*/

    protected void caricaInfo() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(infoName));
        while (br.ready()) {
            String[] s = br.readLine().split("\t");
            String string = s[1];
            for (int i = 2; i < s.length; i++) {
                string = string + "\n" + s[i];
            }
            info.put(s[0], string);
        }
    }

    protected void salvaInfo() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(infoName));

        for(Map.Entry<String,String>entry: info.entrySet()){
            bw.write(entry.getKey()+"\t"+entry.getValue().replace("\n","\t")+"\n");
            bw.flush();
        }
    }

    public HashMap<String, String> getInfo() {
        return info;
    }

    public String getNumeroDelServizio() {
        return numeroDelServizio;
    }
}
