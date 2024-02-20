package optional;

import java.util.ArrayList;
import java.util.List;
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

    /**
     * Let’s say we expect to get a List<String>, and in the case of null, we want to substitute it with a new instance of an ArrayList<String>.
     */
    public static void  orElseGet() {
        //pre java 8 -> String list = getList()
        //pre java 8 -> stringList = list != null ? list : new Arralist<>();
        List<String> stringList = Optional.ofNullable(getList()).orElseGet(ArrayList::new);
    }

    /**
     * Returns a list of strings depending on wheter a random number es even or not.
     * @return List<String> or null
     */
    private static List<String> getList() {
        double randomNumber = Math.random()*10;
        int random = (int) randomNumber;
        return random % 2 == 0 ? List.of("name", "age", "weigh") : null;
    }
}
