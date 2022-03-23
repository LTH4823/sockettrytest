package zerock4.filesend.client;

import lombok.Cleanup;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.Socket;

public class FileGetter {

    public static void main(String[] args) throws Exception{

        @Cleanup Socket socket = new Socket("192.168.0.86",5555);

        @Cleanup DataInputStream din = new DataInputStream(socket.getInputStream());

        String fileName = din.readUTF();

        FileOutputStream fos = new FileOutputStream("C:\\zzz\\" + fileName);

        byte[] buffer = new byte[1024*8];

        while (true){

            int count = din.read(buffer);
            if(count == -1){break;}
            fos.write(buffer,0,count);

        }//end while

    }
}