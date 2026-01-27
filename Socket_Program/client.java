package Socket_Program;

import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) {
        try {
            // Connect to server at localhost on port 5000
            Socket socket = new Socket("localhost", 5000);

            // Output to server
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            // Input from server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Send message to server
            out.println("Hello Server");

            // Read reply from server
            String serverMessage = in.readLine();
            System.out.println("Server says: " + serverMessage);

            // Close socket
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

