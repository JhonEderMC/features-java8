package optional;

import java.util.Optional;

public class UseOptional {
    /**
     * An instance of the Optional class can be created with the help of its static methods.
     */
    public static void empty() {
        Optional<String> optionalEmpty = Optional.empty();
    }

    /**
     * Next, we return an Optional that contains a non-null value
     */
    public static void of() {
        String string = "value";
        Optional<String> optionalString = Optional.of(string);
    }

    public static void ofNullable() {
        String string = null;
        Optional<String> optionalString = Optional.ofNullable(string);
    }
}
