import java.net.*;
import java.util.*;

public class HttpHeaderExample {
    public static void main(String[] args) {
        try {
            // Create URL object
            URL url = new URL("https://www.wikipedia.com");

            // Open connection
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Connect to server
            con.connect();

            // 1. Using getHeaderFields()
            System.out.println("HTTP Header Fields using getHeaderFields():");
            Map<String, List<String>> headers = con.getHeaderFields();

            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

            // 2. Using getHeaderField(int index)
            System.out.println("\nUsing getHeaderField(int):");
            for (int i = 0; i < headers.size(); i++) {
                System.out.println("Header " + i + " : " + con.getHeaderField(i));
            }

            // 3. Using getHeaderField(String name)
            System.out.println("\nUsing getHeaderField(String):");
            System.out.println("Content-Type : " + con.getHeaderField("Content-Type"));
            System.out.println("Server       : " + con.getHeaderField("Server"));

            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
