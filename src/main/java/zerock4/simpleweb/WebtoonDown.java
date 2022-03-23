package zerock4.simpleweb;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class WebtoonDown {

    //bad code
    public static void main(String[] args)throws Exception {

        String header = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.82 Safari/537.36";

        String path= "https://image-comic.pstatic.net/webtoon/748105/160/20220309110152_ef417ca66aa1e439257b874422ff52a7_IMAG01_1.jpg";

        FileOutputStream fos = new FileOutputStream("C:\\zzz\\023.jpg");

        URL url = new URL(path);

        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent",header);

        InputStream in = urlConnection.getInputStream();

        byte[] buffer = new byte[1024*8];

        while (true){
            int count = in.read(buffer);
            if (count==-1){break;}
            fos.write(buffer,0,count);
        }

    }

}
