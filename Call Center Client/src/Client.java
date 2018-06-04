import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
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
            Socket socket = new Socket("172.16.3.109",55556);

            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            dos.writeUTF("6");
            while(true){
                String received = dis.readUTF();
                System.out.println(received);
                if(received.equals("Prenotazione effettuata con successo")||received.equals("BIGLIETTI ESAURITI")){
                    socket.close();
                    break;
                }
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
        catch (EOFException | SocketException e){
            System.out.println("CHIAMATA INTERROTTA");
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
