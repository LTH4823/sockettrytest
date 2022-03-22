package zerock2.client.msg;

import lombok.Builder;
import lombok.Data;

@Data
public class BasicMsg {

    private String from;
    private String text;

    @Builder(builderMethodName = "b1")
    public BasicMsg(String from,String text){
        this.from = from;
        this.text = text;
    }

}