import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void client() throws Exception {
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inetAddress, 9999);
        OutputStream out = socket.getOutputStream();
        out.write("hello 我是客户端！".getBytes());

        out.close();
        socket.close();
    }

    public static void main(String[] args) throws Exception {
        client();
    }
}
