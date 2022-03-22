package web;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QuizWebServer {

    //bad code
    public static void main(String[] args) throws Exception{

        Map<String, String> mimeMap = new HashMap<>();
        mimeMap.put("html","text/html; charset=UTF-8");
        mimeMap.put("mp3","video/mp4");
        mimeMap.put("img","image/jpeg");
        mimeMap.put("jpeg","image/jpeg");
        mimeMap.put("png","image/x-png");

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("server ready...........");


        InputStream inputStream = null;
        FileInputStream fin = null;
        OutputStream out = null;

        while(true){
            try{
                Socket socket = serverSocket.accept();
                inputStream = socket.getInputStream();
                Scanner inScanner = new Scanner(inputStream);

                String firstLine = inScanner.nextLine();
                String[] arr = firstLine.split(" ");

                String target = arr[1].substring(1);

                System.out.println("target: " + target);
                // player.html
                String suffix = target.substring(target.lastIndexOf(".")+1);

                System.out.println("suffix: " + suffix);

                String mimeType = mimeMap.get(suffix);

                File targetFile = new File("C:\\zzz\\img\\"+target);

                long size = targetFile.length();

                fin = new FileInputStream(targetFile);

                out = socket.getOutputStream();

                out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
                out.write(new String("Cache-Control: private\r\n").getBytes());
                out.write(new String("Content-Length: "+size+"\r\n").getBytes());
                out.write(new String("Content-Type: "+mimeType +"\r\n\r\n").getBytes());

                byte[] buffer = new byte[1024*8];


                while(true){
                    try {
                        int count = fin.read(buffer);
                        if (count == -1) {
                            break;
                        }
                        out.write(buffer, 0, count);
                        out.flush();
                    }catch(Exception e){

                    }
                }

                out.close();
                out =null;

                fin.close();
                fin =null;

                inputStream.close();
                inputStream=null;

            }catch (Exception e){
                System.out.println(e.getMessage());

            }finally {
                try {if(out != null) out.close();}catch (Exception e){}
                try {if(fin != null) fin.close();}catch (Exception e){}
                try {if(inputStream != null) inputStream.close();}catch (Exception e){}
            }

        }//end while

    }
}