package Socket_Program;

import java.io.*;
import java.net.*;

public class HalfClosedClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6000);

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Send data to server
            out.println("Hello Server");
            out.println("This is half closed socket");

            // Half-close output stream
            socket.shutdownOutput();
            System.out.println("Client output stream closed");

            // Still receive data from server
            String response = in.readLine();
            System.out.println("Server says: " + response);

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

