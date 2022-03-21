package org.zerock.server;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileSendServer2 {

    public static void main(String[] args)throws Exception {

        //서버 소켓 준비
        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("ready....");

        for (int i = 0; i < 100; i++) {

            try(Socket client =  serverSocket.accept();
                InputStream fin =  new FileInputStream("C:\\zzz\\copy.mp4");
                OutputStream  out = client.getOutputStream();
            ){
                //연결 받고

                System.out.println(client);

                //읽고 쓰기
                byte[] buffer = new byte[1024*8];

                while(true){
                    int count = fin.read(buffer);
                    System.out.println(count);

                    if(count == -1){ break; }
                    out.write(buffer,0, count);
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }

        //닫기
        serverSocket.close();



    }
}
