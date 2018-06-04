package Servizi;

import java.io.*;
import java.net.SocketException;
import java.util.HashMap;

public class PrenotazioneBiglietti extends Servizio {
    //private String infoName;
    private String dataBase;
    //private HashMap<String,String> info;
    private HashMap<String,Integer> biglietti;

    public PrenotazioneBiglietti(String infoName, String dataBase) throws IOException {
        this.infoName = "src\\Database\\"+infoName;
        this.dataBase = "src\\Database\\"+dataBase;

        info = new HashMap<String,String>();
        biglietti = new HashMap<String,Integer>();

        inizializzaServizio();
        caricaInfo();
        caricaDati();
        //System.out.println(biglietti.get("011"));
        //System.out.println(info.get("0"));
    }

    public synchronized boolean prenotaBiglietti(String biglietto){
        if (biglietti.get(biglietto)>0) {
            biglietti.computeIfPresent(biglietto, (k, v) -> v - 1);
            return true;
        }
        System.out.println("BIGLIETTI ESAURITI");
        return false;
    }

    private void inizializzaServizio(){
        numeroDelServizio = Integer.toString(counter);
        counter++;
        try{
            File file = new File(infoName);
            if(!file.exists()){
                file.createNewFile();
            }
            file = new File(dataBase);
            if(!file.exists()){
                file.createNewFile();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private void caricaDati() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(dataBase));
        while (br.ready()) {
            String[] s = br.readLine().split("\t");
            Integer integer = Integer.parseInt(s[1]);
            biglietti.put(s[0],integer);
        }
    }

    public HashMap<String, Integer> getBiglietti() {
        return biglietti;
    }
}
