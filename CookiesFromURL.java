import java.net.*;
import java.io.*;
import java.util.*;

public class CookiesFromURL {

    public static void main(String[] args) {

        try {
            // 1. Create CookieManager
            CookieManager cookieManager = new CookieManager();

            // 2. Accept all cookies
            cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

            // 3. Set as default cookie handler
            CookieHandler.setDefault(cookieManager);

            // 4. URL which sends cookies
            URL url = new URL("https://google.com");

            // 5. Open connection
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // 6. Read response (important to trigger cookie storage)
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            while (br.readLine() != null) {
                // reading response
            }
            br.close();

            // 7. Get cookies from CookieStore
            CookieStore cookieStore = cookieManager.getCookieStore();
            List<HttpCookie> cookies = cookieStore.getCookies();

            System.out.println("Cookies received from URL:");
            for (HttpCookie cookie : cookies) {
                System.out.println("Name  : " + cookie.getName());
                System.out.println("Value : " + cookie.getValue());
                System.out.println("Domain: " + cookie.getDomain());
                System.out.println("--------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
