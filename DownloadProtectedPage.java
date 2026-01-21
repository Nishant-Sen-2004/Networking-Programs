import java.io.*;
import java.net.*;
import java.util.Base64;

public class DownloadProtectedPage {

    public static void main(String[] args) {
        String urlString = "https://www.facebook.com";
        String username = "yourUsername";
        String password = "yourPassword";

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Create Basic Auth header
            String auth = username + ":" + password;
            String encodedAuth = Base64.getEncoder()
                    .encodeToString(auth.getBytes("UTF-8"));

            conn.setRequestProperty("Authorization", "Basic " + encodedAuth);

            // Read response
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            FileWriter writer = new FileWriter("Downloaded_page.html");

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
            }

            reader.close();
            writer.close();

            System.out.println("Page downloaded successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
