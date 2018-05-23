import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client() {
        avviaClient();
    }

    private void avviaClient(){
        Scanner scn = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;

        try{
            scn = new Scanner(System.in);
            //InetAddress ip = InetAddress.getByName("localhost");
            Socket socket = new Socket("172.16.3.21",55556);

            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            dos.writeUTF("0");
            while(true){
                System.out.println(dis.readUTF());
                String tosend = scn.nextLine();
                dos.writeUTF(tosend);

                if(tosend.equals("9")){
                    socket.close();
                    System.out.println("Chiamata terminata");
                    break;
                }

                //String received = dis.readUTF();
                //System.out.println(received);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                scn.close();
                dis.close();
                dos.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
