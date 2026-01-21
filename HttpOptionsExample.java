import java.net.HttpURLConnection;
import java.net.URL;

public class HttpOptionsExample {
    public static void main(String[] args) {

        HttpURLConnection connection = null;

        try {
            // Target URL
            URL url = new URL("https://www.amazon.com");

            // Open connection
            connection = (HttpURLConnection) url.openConnection();

            // Set request method to OPTIONS
            connection.setRequestMethod("OPTIONS");

            // Set timeouts
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Set User-Agent (important for many servers)
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            // Connect
            connection.connect();

            // Print response code
            System.out.println("Response Code : " + connection.getResponseCode());
            System.out.println("Response Message : " + connection.getResponseMessage());

            // Print allowed HTTP methods
            System.out.println("\nAllowed HTTP Methods:");
            String allowMethods = connection.getHeaderField("Allow");
            System.out.println(allowMethods != null ? allowMethods : "Not provided by server");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
