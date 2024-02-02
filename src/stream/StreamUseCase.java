package stream;

import java.util.ArrayList;
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

    public static void anyMatchLetter() {
        String [] letters = new String[]{"a", "b", "c", "d", "e", "f"};
        boolean hasLetterC = Arrays.stream(letters).anyMatch( (letter)-> letter.matches("c"));
        System.out.println("The array has a letter: "+ hasLetterC);

       /* for (String letter: letters) { // Legacy code
            if(letter.matches("c")) {
                return true;
            }
        }*/
    }

    public static  void filtering() {
        ArrayList<String> list = new ArrayList<>();
        list.add("One");
        list.add("OneAndOnly");
        list.add("Derek");
        list.add("Change");
        list.add("factory");
        list.add("justBefore");
        list.add("Italy");
        list.add("Italy");
        list.add("Thursday");
        list.add("");
        list.add("");

        Stream filteredLetters =list.stream().filter((letter) ->letter.contains("d"));
        System.out.println("Words that Contains D: ");
        filteredLetters.forEach((letter) ->System.out.print(" " + letter));
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
