package zerock2.client;

import org.zerock.client.ClientUI;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ClientUI clientUI = new ClientUI(new Scanner(System.in));
        clientUI.addIp();
        clientUI.sendMsg();
    }
}