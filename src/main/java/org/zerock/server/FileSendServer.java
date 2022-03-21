package org.zerock.server;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileSendServer {

    //bad code
    public static void main(String[] args)throws Exception {

        //서버 소켓 준비
        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("ready....");

        for (int i = 0; i < 100; i++) {
            //연결 받고
            Socket client = serverSocket.accept();
            System.out.println(client);
            //파일에 InputStream 연결
            InputStream fin = new FileInputStream("C:\\zzz\\origin.jpg");
            //OutputStream 뽑고
            OutputStream out = client.getOutputStream();
            //읽고 쓰기
            byte[] buffer = new byte[1024*8];

            while(true){
                int count = fin.read(buffer);
                if(count == -1){ break; }
                out.write(buffer,0, count);
            }

            //닫기
            fin.close();
            out.close();
            client.close();
        }

        //닫기
        serverSocket.close();



    }
}
