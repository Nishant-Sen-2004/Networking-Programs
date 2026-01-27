import java.io.*;
import java.net.*;

public class HttpPostDemo {

    public static void main(String[] args) {

        try {
            // Working POST test URL
            URL url = new URL("https://httpbin.org/post");

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Enable POST method
            conn.setRequestMethod("POST");

            // Enable input and output  
            conn.setDoInput(true);
            conn.setDoOutput(true);

            // Set request headers
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // Data to send
            String data = "username=Nishant&course=BCA";

            // Send data to server (OUTPUT)
            OutputStream os = conn.getOutputStream();
            os.write(data.getBytes());
            os.flush();
            os.close();

            // Read response from server (INPUT)
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String line;
            System.out.println("Server Response:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
