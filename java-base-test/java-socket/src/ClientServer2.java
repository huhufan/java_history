import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientServer2 {

    @Test
    public void client() throws Exception {

        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inetAddress, 9998);
        OutputStream out = socket.getOutputStream();
        FileInputStream fin = new FileInputStream(new File("1.jpeg"));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fin.read(bytes)) != -1) {
            out.write(bytes, 0, len);
        }
        System.out.println("客户端数据发送成功");
        out.close();
        socket.close();
    }

    @Test
    public void server() throws Exception {

        ServerSocket serverSocket = new ServerSocket(9998);
        Socket accept = serverSocket.accept();
        InputStream in = accept.getInputStream();
        FileOutputStream fout = new FileOutputStream(new File("2.jpeg"));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = in.read(bytes)) != -1) {
            fout.write(bytes, 0, len);
        }
        System.out.println("已将客户端发送的数据保存");

        fout.close();
        in.close();
        accept.close();
    }


}
