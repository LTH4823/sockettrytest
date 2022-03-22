package zerock2.client;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.zerock.client.Boardcaster;
import org.zerock.client.msg.BasicMsg;

import java.util.Scanner;

@RequiredArgsConstructor
public class ClientUI {

    @NonNull
    private Scanner keyScanner;

    public void addIp(){
        Boardcaster.INSTANCE.addIp("최교득","192.168.0.100");
        Boardcaster.INSTANCE.addIp("김종휘","192.168.0.81");
        Boardcaster.INSTANCE.addIp("이태환","192.168.0.86");
        Boardcaster.INSTANCE.addIp("김상현","192.168.0.99");
    }

    public void sendMsg(){
        String fromStr ="이태환";

        while(true){
            System.out.println("보내고 싶은 메시지를 입력하세요");
            String line = keyScanner.nextLine();
            BasicMsg basicMsg = BasicMsg.b1().from(fromStr).text(line).build();
            Boardcaster.INSTANCE.broadcast(basicMsg);

        }//end while
    }


}