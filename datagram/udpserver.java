package datagram;

import java.net.*;

public class udpserver {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(3000);
        byte[] buffer = new byte[1024];
        System.out.println("Server started. Waiting for messages...");

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            String msg = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received: " + msg);
        }
    }
}

