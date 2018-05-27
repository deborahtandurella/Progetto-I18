package Storico;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Storico {
    private File storico;
    private String nomeStorico;
    private BufferedWriter bw;

    public Storico(String nomeStorico) {
        this.nomeStorico = nomeStorico;

        inizializza();
    }

    private void inizializza(){
        try {
            File file = new File(nomeStorico);
            file.createNewFile();
            bw = new BufferedWriter(new FileWriter(nomeStorico, true));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public synchronized void aggiornastorico(Object ... strings) throws IOException {
        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        bw.write(formatter.format(now.getTime()));
        for(Object stringa : strings) {
            String s = String.valueOf(stringa);
            bw.write("||");
            bw.write(s);
        }
        bw.newLine();
        bw.flush();
    }
}
