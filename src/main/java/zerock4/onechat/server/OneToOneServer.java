package zerock4.onechat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class OneToOneServer {

    //bad code
    public static void main(String[] args)throws Exception {

        ServerSocket serverSocket = new ServerSocket(5555);

        System.out.println("ready...");

        Socket client = serverSocket.accept();
        DataInputStream din = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        Scanner scanner = new Scanner(System.in);

        new Thread(()-> {
            while(true) {
                try {
                    String clientMsg = din.readUTF();
                    System.out.println(clientMsg);
                }catch(Exception e){

                }
            }
        }).start();


        while(true){
            System.out.println("답장을 입력하세요");
            String myMsg = scanner.nextLine();
            dos.writeUTF(myMsg);
        }//end while
    }
}