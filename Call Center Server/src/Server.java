import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    private HashMap<String,String> infoPoint;

    public Server(HashMap infoPoint) {
        this.infoPoint = infoPoint;
        start();
    }

    private void start(){
        try{
            //InetAddress ip = InetAddress.getByName("localhost");
            ServerSocket server = new ServerSocket(55556,50);
            while(true){
                Socket client = server.accept();

                System.out.println("Connessione effettuata da: "+ client);

                System.out.println(client.getInputStream());

                /*switch (client.getInputStream()){
                    System.out.println(client.getInputStream());
                    case "123456":
                        Threads.InfoPointThread newThread = new Threads.InfoPointThread(client);
                        break;
                }*/
                Threads.InfoPointThread newThread = new Threads.InfoPointThread(client,infoPoint);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
