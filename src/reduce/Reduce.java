package reduce;

import reduce.rating.Rating;
import reduce.rating.Review;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reduce {

    private static   Logger logger = Logger.getLogger(Reduce.class.getName());;

    public static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    public static List<String> letters = Arrays.asList("a", "b", "c", "d", "e", "f");


    public static void sumNumbers() {
        int result = numbers.stream().reduce(0, (partialResult, number)-> partialResult + number );
        logger.log (Level.INFO, "The sum is: " + String.valueOf(result));
        //Uses method reference
        result = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Result sum: "+ result);
    }

    public static void concatLetters() {
        String concatLetters = letters.stream().reduce("", (partialSum, letter) -> partialSum + letter);
        System.out.println("Result sum letters: " + concatLetters);
        // use method reference
        concatLetters = letters.stream().reduce("", String::concat);
        System.out.println("Result sum letters: " + concatLetters);
    }

    public static void concatUpperCaseLetters() {
        List<String> letters = Arrays.asList("a", "b", "c", "d", "e", "f");
        String upperCaseConcatLetters = letters.stream().reduce("", (partialResult, letter) -> partialResult + letter.toUpperCase());
        System.out.println(upperCaseConcatLetters);
        //We're not use method reference with toUpperCase this a local opertion to reference
    }

    public  static void sumNumbersParallel() {
        Integer sum = numbers.parallelStream().reduce(0, Integer::sum, Integer::sum);
        System.out.println("Sum: " + sum);
        /*
        * When a stream executes in parallel, the Java runtime splits the stream into multiple substreams. In such cases,
        * we need to use a function to combine the results of the substreams into a single one. This is the role of the
        * combiner — in the above snippet, it’s the Integer::sum method reference.
        * */
    }

    public static void caculateUsersAge() {
        List<User> users = Arrays.asList(new User("John", 30), new User("Julie", 35));

        int totalAgeUsers = users.stream().reduce(0, (partialAgeResul, user) -> partialAgeResul + user.getAge(), Integer::sum);
        System.out.println("Sum age: " + totalAgeUsers);
    }

    public static void divZeroExecption() {
        int divider = 0; // if it's zero then throw exeption
        int sum = numbers.stream().reduce(0, (a, b) -> a/divider + b/divider);
        System.out.println("sum div: " +sum);
    }

    public static void cathZeroExepction() {
        int divider = 0;
        int sum = numbers.stream().reduce(0, (partialAcumulate, number) -> partialAcumulate + divider(number, divider));
        logger.log(Level.INFO,"The sum cath is: "+ String.valueOf(sum));
    }

    private static int divider( Integer number, int divider) {
        try {
            return number / divider;
        } catch (ArithmeticException e) {
            logger.log(Level.SEVERE, "Zero divition is not define");
            return 0;
        }
    }

    public static void ratingAverage() {
        Rating averageRating = createListUsers().stream().reduce(new Rating(), ((rating, user) ->
                Rating.average(rating, user.getRating())), Rating::average);
        logger.log(Level.INFO, "averageRating: " + averageRating.getPoints());
    }

    private static  List<User> createListUsers() {
        User john = new User("John", 30);
        john.setAdress("cra 20b-45");
        john.getRating().add(new Review(5, ""));
        john.getRating().add(new Review(3, "not bad"));
        User julie = new User("Julie", 35);
        julie.setAdress("cll 15# 14-20");
        john.getRating().add(new Review(4, "great!"));
        john.getRating().add(new Review(2, "terrible experience"));
        john.getRating().add(new Review(4, ""));
        return Arrays.asList(john, julie, new User());
    }

    public static List<User> getUsers() {
        return  createListUsers();
    }




}
