import Servizi.InfoPoint;

import java.io.*;

public class CallCenter {
    private InfoPoint infoPoint;

    public CallCenter(String file) throws IOException {
        infoPoint = new InfoPoint(file);
        avviaServer();
    }

    private void avviaServer(){
        Server s = new Server(infoPoint.getInfoPoint());
    }
}
