import java.net.*;

public class URLMethods {
    public static void main(String[] args) {
        try {
            // Create URL object
            URL url = new URL("https://www.youtube.com/watch?v=abc123#section1");

            // Display all URL components
            System.out.println("=== URL Components ===");
            System.out.println("URL            : " + url.toString());
            System.out.println("Protocol       : " + url.getProtocol());
            System.out.println("Host           : " + url.getHost());
            System.out.println("Port           : " + url.getPort());
            System.out.println("Path           : " + url.getPath());
            System.out.println("File           : " + url.getFile());
            System.out.println("Query          : " + url.getQuery());
            System.out.println("Reference      : " + url.getRef());
        } 
        catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
