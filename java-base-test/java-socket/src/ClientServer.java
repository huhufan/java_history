import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientServer {

    @Test
    public void client() throws Exception {
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inetAddress, 9999);
        OutputStream out = socket.getOutputStream();
        out.write("hello 我是客户端！".getBytes());

        out.close();
        socket.close();
    }

    @Test
    public void server() throws Exception {

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


}
