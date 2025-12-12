public class Authenticator_Main {
    public static void main(String[] args) {
        Authenticator auth = new Authenticator();

        System.out.println(auth.register("nishant", "12345")); // true
        System.out.println(auth.register("nishant", "67890")); // false

        System.out.println(auth.login("nishant", "12345"));    // true
        System.out.println(auth.login("nishant", "wrong"));    // false

        System.out.println(auth.updatePassword("nishant", "12345", "99999")); // true
        System.out.println(auth.login("nishant", "99999"));                   // true

        System.out.println(auth.deleteUser("nishant", "99999")); // true
    }
}
