package Socket_Program;

import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) {
        try {
            // Create server socket on port 5000
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started... Waiting for client");

            // Accept client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Input from client
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Output to client
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            // Read message from client
            String clientMessage = in.readLine();
            System.out.println("Client says: " + clientMessage);

            // Send reply to client
            out.println("Hello Client");

            // Close resources
            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

