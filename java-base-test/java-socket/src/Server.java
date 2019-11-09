import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void server() throws Exception {

        ServerSocket serverSocket = new ServerSocket(9999);
        Socket accept = serverSocket.accept();
        InputStream in = accept.getInputStream();
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        int len;
        while ((len = in.read(bytes)) != -1) {
            byteArray.write(bytes, 0, len);
        }
        System.out.println("客户端发过来的内容是" + byteArray.toString());

        byteArray.close();
        in.close();
        accept.close();
    }

    @Test
    public static void main(String[] args) throws Exception {
        server();
    }

}
