import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPSpamCheck {

    public static void main(String[] args) {

        String ip = "196.16.11.222"; // Valid IP for testing
        // String ip = "127.0.0.0";   // Example of non-spam/invalid

        System.out.println("Original IP Address: " + ip);

        // Validate IP format before proceeding
        if (!isValidIP(ip)) {
            System.out.println("Error: Invalid IP format!");
            return;
        }

        // Reverse the IP for DNSBL query
        String reversedIP = reverseIP(ip);
        System.out.println("Reversed IP: " + reversedIP);

        // Perform the spam check
        boolean isSpam = checkSpam(reversedIP);

        System.out.println("-----------------------------------");
        if (isSpam) {
            System.out.println("Result: The IP *IS listed* in spam database.");
        } else {
            System.out.println("Result: The IP is *NOT listed* in spam database.");
        }
        System.out.println("-----------------------------------");
    }

    // Function to reverse the IP address for DNSBL lookup
    public static String reverseIP(String ip) {
        String[] parts = ip.split("\\.");
        StringBuilder reversed = new StringBuilder();

        for (int i = parts.length - 1; i >= 0; i--) {
            reversed.append(parts[i]);
            if (i != 0) {
                reversed.append(".");
            }
        }
        return reversed.toString();
    }

    // Validate IPv4 format
    public static boolean isValidIP(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) return false;

        for (String part : parts) {
            try {
                int value = Integer.parseInt(part);
                if (value < 0 || value > 255) return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    // Perform DNSBL lookup to check if IP is spam
    public static boolean checkSpam(String reversedIP) {
        try {
            String DNSBL = "zen.spamhaus.org";
            String query = reversedIP + "." + DNSBL;

            System.out.println("Querying DNSBL server: " + query);

            InetAddress address = InetAddress.getByName(query);

            System.out.println("DNSBL Response Address: " + address.getHostAddress());
            return true; // found → listed as spam

        } catch (UnknownHostException e) {
            System.out.println("IP not found in DNSBL spam list.");
            return false; // not found → not spam
        }
    }
}
