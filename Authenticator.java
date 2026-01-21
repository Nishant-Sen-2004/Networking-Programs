public class Authenticator {

    // Instance variables
    private final String username;
    private final String password;
    private boolean loggedIn;

    // Constructor
    public Authenticator(String username, String password) {
        this.username = username;
        this.password = password;
        this.loggedIn = false;
    }

    // Method to authenticate user
    public boolean authenticate(String inputUsername, String inputPassword) {

        if (inputUsername == null || inputPassword == null) {
            return false;
        }

        if (this.username.equals(inputUsername) &&
            this.password.equals(inputPassword)) {

            loggedIn = true;
            return true;
        }

        return false;
    }

    // Method to check authentication status
    public boolean isAuthenticated() {
        return loggedIn;
    }

    // Method to logout
    public void logout() {
        loggedIn = false;
    }

    // Main method (Testing)
    public static void main(String[] args) {

        Authenticator auth = new Authenticator("admin", "admin123");

        if (auth.authenticate("admin", "admin123")) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }

        System.out.println("Authenticated: " + auth.isAuthenticated());

        auth.logout();
        System.out.println("Authenticated after logout: " + auth.isAuthenticated());
    }
}
