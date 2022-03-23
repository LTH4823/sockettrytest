package zerock4.simpleweb;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class
SimpleWebServer {

    //bad code
    public static void main(String[] args)throws Exception {

        ServerSocket serverSocket = new ServerSocket(8080);

        while (true){
            Socket socket = serverSocket.accept();
            new Thread(()->{
                try {
                    OutputStream out = socket.getOutputStream();

                    Thread.sleep(1000*5);

                    String msg = "<h1>gogo GoodMorning~!</h1>";

                    out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());

                    out.write(new String("Cache-Control: private\r\n").getBytes());
                    out.write(new String("Content-Length: "+msg.getBytes("UTF-8").length+"\r\n").getBytes());
                    out.write(new String("Content-Type: text/html; chars et=UTF-8\r\n\r\n").getBytes());
                    out.write(msg.getBytes(StandardCharsets.UTF_8));
                }catch (Exception e){}
            }).start();
        }//end while

    }

}
