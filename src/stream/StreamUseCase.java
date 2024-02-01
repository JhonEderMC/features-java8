package stream;

import java.util.Arrays;

import java.util.stream.Stream;

public class StreamUseCase {

    public static void waysCreateFlowStream() {
        String [] arr = new String[] {"a", "b", "c", "d"};
        printValues(arr);
        Stream<String> stream =  Arrays.stream(arr);
        printValues(stream);
        stream = Stream.of(arr);
        printValues(stream);
    }

    public static void useDistinct() {
        int[] numbers = new int[] {1,2,1,3,3,4,4,5,5};
        int [] numbersNoRepeat = Arrays.stream(numbers).distinct().toArray();
        Arrays.stream(numbersNoRepeat).forEach((System.out::print));
        int countNumbersDistinct = (int) Arrays.stream(numbers).distinct().count();
        System.out.println("\nCount distinct numbers: " + countNumbersDistinct);
    }

    public static <T> void printValues(T array) {
        if(array instanceof Stream) {
            printStream((Stream<T>) array);
            //((Stream<?>) array).forEach((System.out::println));
        }else if(array.getClass().isArray()) {
            //List arr = (List)  array;
            // convert T array
        }
    }

    private static <T> void printStream(Stream<T> stream) {
        stream.forEach((System.out::print));
        System.out.println();
    }
}
