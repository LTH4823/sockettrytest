package org.zerock.client;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class FileClient {

    //bad code
    public static void main(String[] args) throws Exception {

        //소켓 연결
        Socket socket = new Socket("127.0.0.1", 5555);
        //파일 준비 FileOutputStream
        FileOutputStream fos = new FileOutputStream("C:\\zzz\\copy.jpg");
        //읽기 준비 InputStream
        InputStream in = socket.getInputStream();
        //읽고 쓰기
        byte[] buffer = new byte[1024*8];
        while(true){
            int count = in.read(buffer);
            if(count == -1){ break; }
            fos.write(buffer,0, count);
        }

        //닫기
        in.close();
        fos.close();
        socket.close();

    }
}
