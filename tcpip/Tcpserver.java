package tcpip;

import java.io.*;
import java.net.*;
import java.nio.file.*;

public class Tcpserver {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(6000)) {
            System.out.println("Server waiting for client...");
            Socket socket = server.accept();
            System.out.println("Client connected.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String fileName = in.readUTF();
            System.out.println("File requested: " + fileName);

            try {
                String content = Files.readString(Paths.get(fileName));
                out.writeUTF(content.isEmpty() ? "FILE IS EMPTY" : content);
                System.out.println("File sent successfully.");
            } catch (IOException e) {
                out.writeUTF("FILE DOESN'T EXIST");
                System.out.println("Error: " + e.getMessage());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
