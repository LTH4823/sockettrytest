package zerock4.common;

import com.google.gson.Gson;

public class GsonTest {

    public static void main(String[] args) {

        ChatMsg chatMsg = new ChatMsg();
        chatMsg.setFrom("보내는 사람");
        chatMsg.setTo("받는사람");
        chatMsg.setText("메시지 내용");

        Gson gson = new Gson();

        String jsonStr =  gson.toJson(chatMsg);

        System.out.println(jsonStr);

    }

}
