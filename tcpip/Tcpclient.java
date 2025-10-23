package tcpip;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Tcpclient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 6000);
             DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Connected to Server.");
            System.out.print("Enter filename to request: ");
            String fileName = sc.nextLine();

            out.writeUTF(fileName);  // send filename
            System.out.println("\n--- File Content ---");
            System.out.println(in.readUTF());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

//first run server then client then enter filename(test.txt) present in tcpip folder to see its content