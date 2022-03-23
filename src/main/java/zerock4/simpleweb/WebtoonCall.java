package zerock4.simpleweb;

import java.net.URL;
import java.util.Scanner;

public class WebtoonCall {

    //bad code
    public static void main(String[] args)throws Exception {

        for (int j = 0; j < 100; j++) {
            new Thread(()->{
                try {
                    URL url = new URL("https://comic.naver.com/webtoon/weekday");
                    Scanner scanner = new Scanner(url.openStream());
                    for (int i = 0; i < 10; i++) {
                        System.out.println(scanner.nextLine());
                    }
                }catch (Exception e){}
            }).start();
        }
    }

}
