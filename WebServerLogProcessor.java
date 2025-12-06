import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WebServerLogProcessor {

    public static void main(String[] args) {
        String logFile = "server.log";  // Path to your log file

        Map<String, Integer> ipCount = new HashMap<>();
        Map<String, Integer> statusCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
            String line;

            while ((line = br.readLine()) != null) {
                processLine(line, ipCount, statusCount);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Print Summary
        System.out.println("\n===== Log Summary =====");
        System.out.println("Requests per IP:");
        ipCount.forEach((ip, count) -> System.out.println(ip + " → " + count));

        System.out.println("\nStatus Code Summary:");
        statusCount.forEach((status, count) -> System.out.println(status + " → " + count));
    }

    private static void processLine(String line, 
                                    Map<String, Integer> ipCount, 
                                    Map<String, Integer> statusCount) {

        // Sample log format:
        // 192.168.1.5 - - [10/Oct/2024:13:55:36 +0530] "GET /index.html HTTP/1.1" 200 1024

        try {
            String[] parts = line.split(" ");

            // Extract fields
            String ip = parts[0];
            String datetime = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
            String request = line.substring(line.indexOf("\"") + 1, line.lastIndexOf("\""));
            String status = parts[parts.length - 2];
            String bytes = parts[parts.length - 1];

            // Update IP count
            ipCount.put(ip, ipCount.getOrDefault(ip, 0) + 1);

            // Update Status count
            statusCount.put(status, statusCount.getOrDefault(status, 0) + 1);

            // Print processed line
            System.out.println("IP: " + ip +
                    " | Time: " + datetime +
                    " | Request: " + request +
                    " | Status: " + status +
                    " | Bytes: " + bytes);

        } catch (Exception e) {
            System.out.println("Failed to parse line: " + line);
        }
    }
}
