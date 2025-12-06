import java.net.*;
import java.util.*;

public class NetworkInterfaceMethods {

    public static void main(String[] args) {

        try {
            // ---------- Factory Method 1: get by name ----------
            System.out.println("=== Using getByName(\"eth0\") ===");
            NetworkInterface niByName = NetworkInterface.getByName("eth0");
            if (niByName != null) {
                printDetails(niByName);
            } else {
                System.out.println("Interface eth0 not found.\n");
            }

            // ---------- Factory Method 2: get by index ----------
            System.out.println("=== Using getByIndex(1) ===");
            NetworkInterface niByIndex = NetworkInterface.getByIndex(1);
            if (niByIndex != null) {
                printDetails(niByIndex);
            } else {
                System.out.println("Interface with index 1 not found.\n");
            }

            // ---------- Factory Method 3: get all interfaces ----------
            System.out.println("=== Using getNetworkInterfaces() ===");
            Enumeration<NetworkInterface> allInterfaces = NetworkInterface.getNetworkInterfaces();

            if (allInterfaces != null) {
                while (allInterfaces.hasMoreElements()) {
                    NetworkInterface ni = allInterfaces.nextElement();
                    printDetails(ni);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Helper method to print all details of a NetworkInterface
    public static void printDetails(NetworkInterface ni) throws SocketException {
        System.out.println("Interface Name       : " + ni.getName());
        System.out.println("Display Name         : " + ni.getDisplayName());
        System.out.println("Is Up?               : " + ni.isUp());
        System.out.println("Is Loopback?         : " + ni.isLoopback());
        System.out.println("Is Virtual?          : " + ni.isVirtual());
        System.out.println("Supports Multicast?  : " + ni.supportsMulticast());
        System.out.println("MTU                  : " + ni.getMTU());

        // Getter method for IP addresses
        System.out.println("IP Addresses         : ");
        Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
        while (inetAddresses.hasMoreElements()) {
            System.out.println("   " + inetAddresses.nextElement());
        }
        System.out.println("-------------------------------------------------------\n");
    }
}
