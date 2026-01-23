import java.net.*;
import java.io.*;

public class HttpTrace {

    public static void main(String[] args) {

        try {
            // IMPORTANT: use HTTP (not HTTPS)
            URL url = new URL("http://httpbin.org/trace");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Set TRACE method
            con.setRequestMethod("TRACE");

            // Set User-Agent (important)
            con.setRequestProperty("User-Agent", "Java-TRACE-Test");

            // Connect
            con.connect();

            System.out.println("Response Code: " + con.getResponseCode());

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
