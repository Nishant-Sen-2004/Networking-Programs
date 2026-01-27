package Socket_Program;

import java.io.*;
import java.net.*;

public class HalfClosedServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6000);
            System.out.println("Server waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            String message;

            // Read until client half-closes output
            while ((message = in.readLine()) != null) {
                System.out.println("Client says: " + message);
            }

            System.out.println("Client has half-closed output");

            // Server still sends response
            out.println("Hello Client, I received your data");

            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

