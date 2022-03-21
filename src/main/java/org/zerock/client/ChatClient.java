package org.zerock.client;

import lombok.Cleanup;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class ChatClient {
    //bad code
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String msg = scanner.nextLine();
            System.out.println(msg);

            @Cleanup Socket socket = new Socket("192.168.0.100", 5555);
            @Cleanup Socket socket1 = new Socket("192.168.0.81", 8080);
//            @Cleanup Socket socket2 = new Socket("192.168.0.86", 8080);
//            @Cleanup Socket socket3 = new Socket("192.168.0.99", 8080);

            //아웃
            @Cleanup OutputStream out = socket.getOutputStream();
            @Cleanup OutputStream out1 = socket1.getOutputStream();
//            @Cleanup OutputStream out2 = socket2.getOutputStream();
//            @Cleanup OutputStream out3 = socket3.getOutputStream();


            byte[] arr = msg.getBytes(StandardCharsets.UTF_8);
            out.write(arr);
            out1.write(arr);
//            out2.write(arr);
//            out3.write(arr);
        }


    }

}