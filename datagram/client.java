package datagram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        Scanner sc = new Scanner(System.in);

        System.out.println("Client ready. Type messages to send:");
        while (true) {
            String msg = sc.nextLine();
            DatagramPacket packet = new DatagramPacket(
                msg.getBytes(), msg.length(), ip, 3000);
            socket.send(packet);
        }
    }
}


//first run server then client then type messages in client console to see them in server console