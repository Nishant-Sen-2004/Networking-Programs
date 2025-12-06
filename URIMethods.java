import java.net.*;

public class URIMethods {
    public static void main(String[] args) {
        try {
            // Create a URI object
            URI uri = new URI("https://username:password@example.com:443/products/list?id=10&cat=book#section2");

            System.out.println("=== URI Components ===");
            System.out.println("URI           : " + uri.toString());
            System.out.println("Scheme        : " + uri.getScheme());
            System.out.println("Authority     : " + uri.getAuthority());
            System.out.println("User Info     : " + uri.getUserInfo());
            System.out.println("Host          : " + uri.getHost());
            System.out.println("Port          : " + uri.getPort());
            System.out.println("Path          : " + uri.getPath());
            System.out.println("Query         : " + uri.getQuery());
            System.out.println("Fragment      : " + uri.getFragment());
            System.out.println("Is Absolute   : " + uri.isAbsolute());

            // Demonstrating resolve()
            URI baseURI = new URI("https://example.com/products/");
            URI relativeURI = new URI("item1.html");

            URI resolved = baseURI.resolve(relativeURI);
            System.out.println("\nResolved URI  : " + resolved);

            // Demonstrating relativize()
            URI uri1 = new URI("https://example.com/products/item1.html");
            URI uri2 = new URI("https://example.com/products/");
            
            URI relative = uri2.relativize(uri1);
            System.out.println("Relativized   : " + relative);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
