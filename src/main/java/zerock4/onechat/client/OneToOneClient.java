package zerock4.onechat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class OneToOneClient {

    //bad code
    public static void main(String[] args) throws Exception{

        Socket socket = new Socket("192.168.0.86",5555);
        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
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