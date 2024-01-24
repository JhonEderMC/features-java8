package reduce;

import java.util.Arrays;
import java.util.List;

public class Reduce {

    public static void sumNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Integer result = numbers.stream().reduce(0, (partialResult, number)-> partialResult + number );
        System.out.println("Result sum: "+ result);
        result =0;
        //Uses method reference
        result = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Result sum: "+ result);
    }
}
