import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.imageio.ImageIO;

public class ThreadClient implements Runnable , Serializable {
    private BufferedImage bufferedImage;
    public ThreadClient(BufferedImage  image){
        this.bufferedImage = image;

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            Socket s = new Socket();
            //接受视频端IP和端口
            s.connect(new InetSocketAddress("127.0.0.1", 40000), 2000);

            if(s.isConnected() && !s.isClosed()){

                System.out.println("Client:"+s.getRemoteSocketAddress().toString());
                OutputStream oos = s.getOutputStream();
                ImageIO.write(bufferedImage,"JPG",oos);
                oos.write("\n".getBytes());
                oos.flush();
                oos.close();
                s.close();
            }

        }  catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



}