package zerock2.server;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MsgServer {
    public static void main(String[] args)throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("read......................");

        while (true){
            try (Socket client = serverSocket.accept();
                 InputStream in = client.getInputStream();
                 Scanner inScanner = new Scanner(in);){

                String msg = inScanner.nextLine();
                System.out.println(msg);

            }catch (Exception e){
                System.out.println("Exception.................");
                System.out.println(e.getMessage());
            }

        }
    }
}
