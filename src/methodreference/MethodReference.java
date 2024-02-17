package methodreference;

import reduce.User;

import java.util.Arrays;
import java.util.List;

public class MethodReference {

    public static List<User> users = Arrays.asList(new User("Luisa", 20), new User(("Daniel"), 30));

    /**
     * The reference to a static method holds the syntax ContainingClass::methodName.
     */

    public static void staticMethodReference() {
        //users.stream().anyMatch((user -> User.isRealUser(user)));
        boolean isReal = users.stream().anyMatch((User::isRealUser));
        System.out.println("is Real: " + isReal);
    }

    public static void referenceInstanceMethod() {
        //Some user has legal name
        boolean isLegalName = users.stream().anyMatch(User::isLegalName);
        System.out.println("Some user has legal name: "+ isLegalName);
    }

}
