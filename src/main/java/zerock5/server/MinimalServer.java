package zerock5.server;

import lombok.Cleanup;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MinimalServer {

    //bad code
    public static void main(String[] args)throws Exception {

        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("ready.................................");

        ArrayList<DataOutputStream> dosList = new ArrayList<>();

        while (true){
            Socket socket = serverSocket.accept();
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            synchronized (dosList){
                dosList.add(dos);
            }

            System.out.println(socket);

            new  Thread(()->{
                while (true){
                    try {
                        String clientMsg = din.readUTF();
                        System.out.println(clientMsg);

                        for (DataOutputStream clientDos:dosList) {
                            clientDos.writeUTF("\tSERVER: "+clientMsg);
                        }
                    }catch (Exception e){
                        synchronized (dosList){
                            dosList.remove(dos);
                            System.out.println(dosList);
                        }
                        break;
                    }
                }//end while 별개 동작
            }).start();// sub Thread
        }//end while main Thread
    }
}
