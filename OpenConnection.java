import java.net.*;
import java.io.*;

public class OpenConnection {
    public static void main(String[] args) {
        try {
            // Create URL object
            URL url = new URL("https://www.example.com");

            // Open a connection to the URL
            URLConnection connection = url.openConnection();

            // Optional: Set timeouts
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Display connection information
            System.out.println("=== URL Connection Details ===");
            System.out.println("Content Type : " + connection.getContentType());
            System.out.println("Content Length : " + connection.getContentLength());
            System.out.println("Date : " + connection.getDate());
            System.out.println("Last Modified : " + connection.getLastModified());

            // Read content from the connection
            System.out.println("\n=== Content from URL ===");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
