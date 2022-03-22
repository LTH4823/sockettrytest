package zerock3.simpleclient;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SimpleClient {
    //bad code
    public static void main(String[] args)throws Exception {

        String name = "태퐝~";

        Scanner scanner = new Scanner(System.in);

        System.out.println("보내고 싶은 메세지는?");

        String msg = scanner.nextLine();

        String msgStr = name + ": "+msg+"\n";

        Socket socket = new Socket("192.168.0.86",8080);
        OutputStream out = socket.getOutputStream();
        out.write(msgStr.getBytes(StandardCharsets.UTF_8));

    }
}
