import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.net.*;

public class UDP {

    @Test
    public void send() throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket();
        byte[] data = "你好，我是使用UDP方式发送的数据".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(data, 0, data.length, InetAddress.getByName("127.0.0.1"), 9996);
        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }

    @Test
    public void receive() throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(9996);
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
        datagramSocket.receive(packet);
        System.out.println(new String(packet.getData(), 0, packet.getLength()));

        datagramSocket.close();
    }
}
