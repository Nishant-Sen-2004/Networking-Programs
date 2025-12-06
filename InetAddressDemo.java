import java.net.InetAddress;

public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            // Get InetAddress object using hostname
            InetAddress inet = InetAddress.getByName("nepathyacollege.edu.np");

            // ------- Getter Methods -------
            System.out.println("Host Name: " + inet.getHostName());
            System.out.println("Canonical Host Name: " + inet.getCanonicalHostName());
            System.out.println("Host Address: " + inet.getHostAddress());

            byte[] addressBytes = inet.getAddress();
            System.out.print("Address (bytes): ");
            for (byte b : addressBytes) {
                System.out.print((b & 0xFF) + ".");
            }
            System.out.println();

            // ------- Testing Reachability -------
            System.out.println("Is Reachable (2 sec timeout): " + inet.isReachable(2000));

            // ------- Object Methods -------
            InetAddress inet2 = InetAddress.getByName("nepathyacollege.edu.np");
            System.out.println("Equals: " + inet.equals(inet2));
            System.out.println("HashCode: " + inet.hashCode());
            System.out.println("ToString: " + inet.toString());

            // ------- Address Type Methods -------
            System.out.println("Is Any Local Address: " + inet.isAnyLocalAddress());
            System.out.println("Is Loopback Address: " + inet.isLoopbackAddress());
            System.out.println("Is Link Local Address: " + inet.isLinkLocalAddress());
            System.out.println("Is Site Local Address: " + inet.isSiteLocalAddress());
            System.out.println("Is Multicast Address: " + inet.isMulticastAddress());

            System.out.println("Is MC Global: " + inet.isMCGlobal());
            System.out.println("Is MC Node Local: " + inet.isMCNodeLocal());
            System.out.println("Is MC Link Local: " + inet.isMCLinkLocal());
            System.out.println("Is MC Site Local: " + inet.isMCSiteLocal());
            System.out.println("Is MC Org Local: " + inet.isMCOrgLocal());

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
