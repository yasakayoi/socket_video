import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class socketService {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(3000);
        System.out.println("begin");
        System.out.println("Hello World!");
        while(true){

            new Thread(new TheadServer(ss)).start();
        }
    }
}