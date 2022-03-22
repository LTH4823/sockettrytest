package zerock2.client;



import org.zerock.client.msg.BasicMsg;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Boardcaster {
    INSTANCE;

    private Map<String,String> ipMap;

    Boardcaster(){
        ipMap = new HashMap<>();
    }

    public void addIp(String name,String ip){
        ipMap.put(name,ip);
    }

    public void broadcast(final BasicMsg msg) {

        if(ipMap == null || ipMap.size() == 0){
            return;
        }

        for (String ip: ipMap.values()) {

            try(Socket socket = new Socket(ip,8080);
                OutputStream out = socket.getOutputStream();
            ){
                String msgStr = msg.getFrom()+": "+msg.getText();
                byte[] msgArr = (msgStr+"\n").getBytes(StandardCharsets.UTF_8);
                out.write(msgArr);
                out.flush();

            }catch(Exception e){
                System.out.println(ip +":" + e.getMessage());
            }//end catch
        }//end for

    }//end method
}//end class









