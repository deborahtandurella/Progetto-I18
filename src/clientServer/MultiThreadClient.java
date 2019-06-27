package clientServer;

public class MultiThreadClient {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Client();
        t1.start();
        t1.join();
    }
}
