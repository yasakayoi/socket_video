import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.imageio.ImageIO;

public class TheadServer implements Runnable {
    private Socket s = null;
    private BufferedImage bufferedImage;
    public InputStream ins;
    public TheadServer(ServerSocket ss ) throws IOException{
        System.out.println("start thread");
        this.s=ss.accept();
    }

    @Override
    public void run(){
        try {
            ins = s.getInputStream();
            bufferedImage = ImageIO.read(ins);
            ins.close();
            ThreadClient tc = new ThreadClient(bufferedImage);
            new Thread(tc).start();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }finally{
            try {
                if(!s.isClosed())
                    s.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}