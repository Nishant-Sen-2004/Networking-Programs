import java.util.HashMap;
import java.util.Map;

public class Authenticator {

    // Stores username → password pairs
    private Map<String, String> users;

    // Constructor
    public Authenticator() {
        users = new HashMap<>();
    }

    /**
     * Registers a new user with a username and password.
     * Returns true if registration is successful.
     */
    public boolean register(String username, String password) {
        if (users.containsKey(username)) {
            return false; // User already exists
        }
        users.put(username, password);
        return true;
    }

    /**
     * Authenticates a user.
     * Returns true if username exists and password matches.
     */
    public boolean login(String username, String password) {
        if (!users.containsKey(username)) {
            return false; // User not found
        }
        return users.get(username).equals(password);
    }

    /**
     * Updates password for an existing user.
     */
    public boolean updatePassword(String username, String oldPassword, String newPassword) {
        if (login(username, oldPassword)) {   // reuse login() for verification
            users.put(username, newPassword);
            return true;
        }
        return false;
    }

    /**
     * Removes a user from the system.
     */
    public boolean deleteUser(String username, String password) {
        if (login(username, password)) {
            users.remove(username);
            return true;
        }
        return false;
    }
}
