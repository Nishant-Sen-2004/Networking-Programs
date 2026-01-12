import java.util.HashMap;

class UserManager {

    private HashMap<String, String> data = new HashMap<>();

    boolean addUser(String name, String pass) {
        if (data.get(name) != null) {
            return false;
        }
        data.put(name, pass);
        return true;
    }

    boolean checkUser(String name, String pass) {
        String stored = data.get(name);
        return stored != null && stored.equals(pass);
    }

    boolean changePassword(String name, String oldPass, String newPass) {
        if (checkUser(name, oldPass)) {
            data.put(name, newPass);
            return true;
        }
        return false;
    }

    boolean removeUser(String name, String pass) {
        if (checkUser(name, pass)) {
            data.remove(name);
            return true;
        }
        return false;
    }
}

public class MainApp {
    public static void main(String[] args) {

        UserManager um = new UserManager();

        System.out.println("Register user: " + um.addUser("nishant", "12345"));
        System.out.println("Register same user again: " + um.addUser("nishant", "67890"));

        System.out.println("Login with correct password: " + um.checkUser("nishant", "12345"));
        System.out.println("Login with wrong password: " + um.checkUser("nishant", "wrong"));

        System.out.println("Change password: " + um.changePassword("nishant", "12345", "99999"));
        System.out.println("Login with new password: " + um.checkUser("nishant", "99999"));

        System.out.println("Delete user: " + um.removeUser("nishant", "99999"));
    }
}
