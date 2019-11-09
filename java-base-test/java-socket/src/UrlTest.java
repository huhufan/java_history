import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class UrlTest {
    @Test
    public void download() throws IOException {
        URL url = new URL("https://www.baidu.com");
        URLConnection connection = url.openConnection();
        Map<String, List<String>> headerFields = connection.getHeaderFields();

        //获取请求头
        for (Map.Entry entry : headerFields.entrySet()) {
            System.out.print(entry.getKey() + " :");
            System.out.print(entry.getValue() + "\n");
        }

        InputStream inputStream = connection.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("download.txt");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }

        fileOutputStream.close();
        inputStream.close();
    }
}
