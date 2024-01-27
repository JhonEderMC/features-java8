package reduce;

import java.util.Arrays;
import java.util.List;

public class Reduce {

    public static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    public static List<String> letters = Arrays.asList("a", "b", "c", "d", "e", "f");


    public static void sumNumbers() {
        int result = numbers.stream().reduce(0, (partialResult, number)-> partialResult + number );
        System.out.println("Result sum: "+ result);
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


}
