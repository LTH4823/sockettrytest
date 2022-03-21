package org.zerock.server;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileSendServer1 {

    public static void main(String[] args)throws Exception {

        //서버 소켓 준비
        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("ready....");

        for (int i = 0; i < 100; i++) {
            Socket client = null;
            InputStream fin = null;
            OutputStream out = null;

            try{
                //연결 받고
                client = serverSocket.accept();
                System.out.println(client);
                //파일에 InputStream 연결
                fin = new FileInputStream("C:\\zzz\\copy.mp4");
                //OutputStream 뽑고
                out = client.getOutputStream();

                //읽고 쓰기
                byte[] buffer = new byte[1024*8];

                while(true){
                    int count = fin.read(buffer);
                    System.out.println(count);
                    
                    if(count == -1){ break; }
                    out.write(buffer,0, count);
                }
                fin.close();
                fin = null;

                out.close();
                out = null;

                client.close();
                client = null;


            }catch(Exception e){
                e.printStackTrace();
            }finally {
                System.out.println("finally...................");
                if(fin != null) try { fin.close(); }catch(Exception e){ }
                if(out != null) try { out.close(); }catch(Exception e){ }
                if(client != null) try { client.close(); }catch(Exception e){ }
            }

        }

        //닫기
        serverSocket.close();



    }
}
