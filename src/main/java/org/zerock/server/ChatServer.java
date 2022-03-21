package org.zerock.server;

import lombok.Cleanup;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatServer {
    //bad code
    public static void main(String[] args) throws Exception {
        @Cleanup ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("Server Ready....");


        byte[] buffer = new byte[1024*8];
        for (int i = 0; i < 100; i++) {
            @Cleanup Socket client = serverSocket.accept();
            @Cleanup InputStream in = client.getInputStream();
            int count = in.read(buffer);
            String str = new String(buffer,0,count, StandardCharsets.UTF_8);
            System.out.println(str);
        }

    }

}