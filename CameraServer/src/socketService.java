import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class socketService {


    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(3000);
        System.out.println("Hello ！");
        while(true){

            new Thread(new TheadServer(ss)).start();
        }
    }
}