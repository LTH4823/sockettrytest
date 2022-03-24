package zerock5.client;

import org.zerock2.client.sub.Loop1;

public class OneToOne {

    public static void main(String[] args) {

        Loop1[] arr = {new Loop1(),new Loop1(),new Loop1(),new Loop1()};

        for (int i = 0; i < arr.length; i++) {
            arr[i].start();

        }
        System.out.println("===================================");
    }
}
