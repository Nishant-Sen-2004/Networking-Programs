import java.net.*;
import java.io.*;

public class OpenStream {
    public static void main(String[] args) {
        try {
            // Create the URL object
            URL url = new URL("https://www.example.com");

            // Open stream (shortcut to read data directly)
            InputStream inputStream = url.openStream();

            // Wrap it with BufferedReader to read line-by-line
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            System.out.println("=== Content of the URL ===");
            
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            // Close the stream
            br.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
