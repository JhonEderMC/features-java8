package reduce;

import reduce.rating.Rating;
import reduce.rating.Review;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Reduce {

    private static   Logger logger = Logger.getLogger(Reduce.class.getName());;

    private static final List<Integer> numbers = List.of(1,2,3,5,3,-1,10,-11,7);

    public static List<String> letters = Arrays.asList("a", "b", "c", "d", "e", "f");


    public static void sumNumbers() {
        int result = numbers.stream().reduce(0, (partialResult, number)-> partialResult + number );
        logger.log (Level.INFO, "The sum is: " + String.valueOf(result));
        //Uses method reference
        result = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Result sum: "+ result);
    }

    public static void range() {
       int result = IntStream.range(1,4).reduce(0, Integer::sum);
       System.out.println("IntStream.range(1,4): " + result);

        //reducedTwoParams = 16 (10 + 1 + 2 + 3)
        result = Stream.of(1, 2, 3).reduce(10, (a ,b) -> a+b,
                (a,b )-> {
                    System.out.print("combiner was called");
                    return a + b;
                });
        System.out.println("Stream.of(1, 2, 3).reduce(10, (a ,b) -> a+b,\n" +
                "                (a,b )-> {\n" +
                "                    System.out.print(\"cobiner was called\");\n" +
                "                    return a + b;\n" +
                "                }): " + result);
        /* The result will be the same as in the previous example (16), and there will be no login, which means that
            combiner wasn’t called. To make a combiner work, a stream should be parallel:
         */
        result = Arrays.asList(1,2,3).stream().parallel().reduce(10, Integer::sum,
                (partialSum, number) -> {
                    System.out.print("combiner was called");
                    return  partialSum + number;
                });
        System.out.println("Arrays.asList(1,2,3).stream().parallel().reduce(10, Integer::sum,\n" +
                "                (partialSum, number) -> {\n" +
                "                    System.out.print(\"cobiner was called\");\n" +
                "                    return  partialSum + number;\n" +
                "                }): " + result);
        /*
            The result here is different (36), and the combiner was called twice. Here the reduction works by the
            following algorithm: the accumulator ran three times by adding every element of the stream to identity.
            These actions are being done in parallel. As a result, they have (10 + 1 = 11; 10 + 2 = 12; 10 + 3 = 13;).
            Now combiner can merge these three results. It needs two iterations for that (12 + 13 = 25; 25 + 11 = 36).
         */
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

    public static void minNumber() {
        Integer min = numbers.stream().reduce(0, (minNumber, number) -> minNumber <= number ? minNumber : number);
        System.out.println("Min number is: " +  min);
    }

    public static void maxNumber() {
        Integer max = numbers.stream().reduce(0, (maxNumber, number) -> maxNumber < number ? number : maxNumber);
        System.out.println("Max number is: " + max);
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
