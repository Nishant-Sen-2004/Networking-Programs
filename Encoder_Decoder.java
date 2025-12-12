import java.net.*;

public class Encoder_Decoder {
    public static void main(String[] args) {
        try {
            // Original query parameters
            String name = "Nishant Sen";
            String city = "Kotihawa, Rupendehi";
            String search = "Java Programming @ 2025";

            System.out.println("=== ORIGINAL VALUES ===");
            System.out.println("Name   : " + name);
            System.out.println("City   : " + city);
            System.out.println("Search : " + search);

            // --- ENCODING ---
            String encodedName = URLEncoder.encode(name, "UTF-8");
            String encodedCity = URLEncoder.encode(city, "UTF-8");
            String encodedSearch = URLEncoder.encode(search, "UTF-8");

            System.out.println("\n=== ENCODED VALUES ===");
            System.out.println("Name   : " + encodedName);
            System.out.println("City   : " + encodedCity);
            System.out.println("Search : " + encodedSearch);

            // --- DECODING BACK ---
            String decodedName = URLDecoder.decode(encodedName, "UTF-8");
            String decodedCity = URLDecoder.decode(encodedCity, "UTF-8");
            String decodedSearch = URLDecoder.decode(encodedSearch, "UTF-8");

            System.out.println("\n=== DECODED VALUES ===");
            System.out.println("Name   : " + decodedName);
            System.out.println("City   : " + decodedCity);
            System.out.println("Search : " + decodedSearch);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
