package zerock3.simpleserver;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class SimpleServer {
    //bad code
    public static void main(String[] args)throws Exception {

        Set<String> ipSet = new HashSet<>();

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("server ready................................");

        while (true){
            Socket socket = serverSocket.accept();
            InetSocketAddress address = (InetSocketAddress)socket.getRemoteSocketAddress();

            String ip = address.getAddress().getHostAddress();

            System.out.println(ip);

            ipSet.add(ip);

            System.out.println(ipSet);

            InputStream in = socket.getInputStream();
            Scanner inScanner = new Scanner(in);

            String line = inScanner.nextLine();

            System.out.println(line);

            System.out.println("--------------------------------");

            ipSet.forEach(ipStr-> {
                try(Socket socket1 = new Socket(ipStr,8080);
                    OutputStream outputStream = socket1.getOutputStream();) {
                    byte[] arr = (line+"\n").getBytes(StandardCharsets.UTF_8);
                    outputStream.write(arr);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            });

        }//while end
    }
}
