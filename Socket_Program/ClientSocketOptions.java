package Socket_Program;

import java.net.*;

public class ClientSocketOptions {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 7000);

            // -------- SETTER METHODS --------
            socket.setSoTimeout(4000);          // 4 seconds timeout
            socket.setTcpNoDelay(true);         // Disable Nagle's algorithm
            socket.setReuseAddress(true);       // Allow reuse of address
            socket.setKeepAlive(true);          // Keep connection alive

            // -------- GETTER METHODS --------
            System.out.println("Socket Timeout: " + socket.getSoTimeout());
            System.out.println("TCP No Delay: " + socket.getTcpNoDelay());
            System.out.println("Reuse Address: " + socket.getReuseAddress());
            System.out.println("Keep Alive: " + socket.getKeepAlive());
            System.out.println("Local Port: " + socket.getLocalPort());
            System.out.println("Remote Port: " + socket.getPort());

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

