import java.net.*;
import java.util.*;

public class URLConnectionHeaders {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com");
            URLConnection con = url.openConnection();

            // Establish connection
            con.connect();

            /* -------------------------------
               Retrieving Specific MIME Headers
               ------------------------------- */
            System.out.println("=== Specific MIME Header Fields ===");
            System.out.println("Content-Type      : " + con.getContentType());
            System.out.println("Content-Length    : " + con.getContentLength());
            System.out.println("Content-Encoding  : " + con.getContentEncoding());
            System.out.println("Date              : " + con.getDate());
            System.out.println("Last Modified     : " + con.getLastModified());
            System.out.println("Expiration        : " + con.getExpiration());

            /* -------------------------------
               Retrieving Arbitrary Header Fields
               ------------------------------- */
            System.out.println("\n=== All Header Fields ===");
            Map<String, List<String>> headers = con.getHeaderFields();

            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
