package zerock4.filesend.server;

import lombok.Cleanup;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileSendServer {

    //bad code
    public static void main(String[] args)throws Exception {

        @Cleanup ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("ready......................");

        while (true){
            @Cleanup Socket socket = serverSocket.accept();
            System.out.println(socket);

            @Cleanup DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            dos.writeUTF("3.jpg");

            byte[] buffer = new byte[1024*8];

            FileInputStream fin = new FileInputStream("C:\\zzz\\img\\3.jpg");

            while (true){
                int count = fin.read(buffer);
                if(count==-1){break;}
                dos.write(buffer,0,count);
            }

        }
    }
}
