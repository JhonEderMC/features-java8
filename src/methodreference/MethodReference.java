package methodreference;

import reduce.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MethodReference {

    public static List<User> users = Arrays.asList(new User("Luisa", 20), new User(("Daniel"), 30),
            new User("", 20));

    /**
     * The reference to a static method holds the syntax ContainingClass::methodName.
     */

    public static void staticMethodReference() {
        //users.stream().anyMatch((user -> User.isRealUser(user)));
        boolean isReal = users.stream().anyMatch((User::isRealUser));
        System.out.println("is Real: " + isReal);
    }

    /**
     * The reference to an instance method holds the syntax ContainingClass::methodName.
     */
    public static void referenceInstanceMethod() {
        //Some user has legal name
        boolean isLegalName = users.stream().anyMatch(User::isLegalName);
        System.out.println("Some user has legal name: "+ isLegalName);
    }
    /**
     * The reference to particular Type Instance method holds the syntax ContainingClass::methodName.
     */
    public static void referenceInstanceMethodObjectParticularType() {
        Long numberEmptyNames = users.stream().map(User::getName).filter(String::isEmpty).count();
        System.out.println("Number of user with empty name: " + numberEmptyNames);
    }

    /**
     * The reference to particular Type Instance method holds the syntax ContainingClass::methodName.
     */
    public static void referenceToConstructor() {
        Stream<User> usrs = users.stream().map(User::new);
    }


}
