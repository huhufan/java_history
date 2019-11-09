import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientServer3 {

    @Test
    public void client() throws Exception {

        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inetAddress, 9997);
        OutputStream out = socket.getOutputStream();
        FileInputStream fin = new FileInputStream(new File("1.jpeg"));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fin.read(bytes)) != -1) {
            out.write(bytes, 0, len);
        }
        //需要关闭此socket的输出流，不如服务端会处于一直读取socket输入流的阻塞状态
        socket.shutdownOutput();
        InputStream input = socket.getInputStream();
        byte[] bytes2 = new byte[1024];
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        int len2;
        while ((len2 = input.read(bytes2)) != -1) {
            byteArray.write(bytes2, 0, len2);
        }
        System.out.println("服务端的回应： " + byteArray.toString());
        byteArray.close();
        input.close();
        fin.close();
        out.close();
        socket.close();
    }

    @Test
    public void server() throws Exception {

        ServerSocket serverSocket = new ServerSocket(9997);
        Socket accept = serverSocket.accept();
        InputStream in = accept.getInputStream();
        FileOutputStream fout = new FileOutputStream(new File("2.jpeg"));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = in.read(bytes)) != -1) {
            fout.write(bytes, 0, len);
        }
        OutputStream out = accept.getOutputStream();
        out.write("我是服务端，我已经收到了你的照片".getBytes());

        out.close();
        fout.close();
        in.close();
        accept.close();
    }


}
