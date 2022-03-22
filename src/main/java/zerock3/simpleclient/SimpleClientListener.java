package zerock3.simpleclient;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClientListener {
    //bad code
    public static void main(String[] args)throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("client listener ready.....................");

        while (true){
            Socket socket = serverSocket.accept();
            Scanner inScanner = new Scanner(socket.getInputStream());

            System.out.println(inScanner.nextLine());

        }
    }
}
