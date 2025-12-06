import java.net.*;
import java.util.*;

public class NetworkInterfaceDetails {
    public static void main(String[] args) {

        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface netIf = interfaces.nextElement();

                System.out.println("=====================================================");
                System.out.println("Interface Name     : " + netIf.getName());
                System.out.println("Display Name       : " + netIf.getDisplayName());
                System.out.println("-----------------------------------------------------");

                // Status
                System.out.println("Is Up?             : " + netIf.isUp());
                System.out.println("Is Loopback?       : " + netIf.isLoopback());
                System.out.println("Is Virtual?        : " + netIf.isVirtual());
                System.out.println("Supports Multicast?: " + netIf.supportsMulticast());
                System.out.println("MTU                : " + netIf.getMTU());

                // Parent Interface
                NetworkInterface parent = netIf.getParent();
                System.out.println("Parent Interface   : " + 
                    (parent != null ? parent.getName() : "None"));

                // Sub Interfaces
                Enumeration<NetworkInterface> subIfs = netIf.getSubInterfaces();
                while (subIfs.hasMoreElements()) {
                    NetworkInterface sub = subIfs.nextElement();
                    System.out.println("  Sub-Interface    : " + sub.getName() + 
                                       " (" + sub.getDisplayName() + ")");
                }

                // MAC Address
                byte[] mac = netIf.getHardwareAddress();
                if (mac != null) {
                    System.out.print("MAC Address        : ");
                    for (int i = 0; i < mac.length; i++) {
                        System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
                    }
                    System.out.println();
                } else {
                    System.out.println("MAC Address        : Not Available");
                }

                // IP addresses
                System.out.println("IP Addresses:");
                Enumeration<InetAddress> addrs = netIf.getInetAddresses();
                while (addrs.hasMoreElements()) {
                    InetAddress addr = addrs.nextElement();
                    System.out.println("  Address          : " + addr.getHostAddress());
                    System.out.println("    Host Name      : " + addr.getHostName());
                    System.out.println("    Canonical Name : " + addr.getCanonicalHostName());

                    if (addr instanceof Inet4Address) {
                        System.out.println("    Type           : IPv4");
                    } else if (addr instanceof Inet6Address) {
                        System.out.println("    Type           : IPv6");
                    } else {
                        System.out.println("    Type           : Unknown");
                    }
                }

                // Interface Addresses (Subnet Mask, Broadcast)
                System.out.println("Interface Address Details:");
                for (InterfaceAddress intAddr : netIf.getInterfaceAddresses()) {
                    InetAddress addr = intAddr.getAddress();
                    InetAddress broadcast = intAddr.getBroadcast();
                    short prefix = intAddr.getNetworkPrefixLength();

                    System.out.println("  Address          : " + addr.getHostAddress());
                    System.out.println("    Broadcast      : " + 
                        (broadcast != null ? broadcast.getHostAddress() : "None"));
                    System.out.println("    Prefix Length  : " + prefix);
                }

                System.out.println("=====================================================\n");
            }

        } catch (SocketException e) {
            System.out.println("Error: " + e);
        }
    }
}
