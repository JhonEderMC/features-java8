package stream;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamUseCase {

    /**
     * Create and an empty Stream
     */
    public static void emptyStream() {
        Stream<String> streamEmpty = Stream.empty();
    }

    /**
     * We often use the empty() method upon creation to avoid returning null for streams with no element:
     * @param list
     * @return
     */
    public static Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }

    /**
     * We can also create a stream of any type of Collection (Collection, List, Set):
     */
    public static void streamOfCollection() {
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();
    }

    /**
     * An array can also be the source of a stream:
     */
    public static void streamOfArray() {
        Stream<String> streamOfArray = Stream.of("a", "b", "c", "d", "e");

        //We can also create a stream out of an existing array or of part of an array
        String [] arr = new String[] {"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streaOfArrayPart = Arrays.stream(arr, 1, 3);
        printStream(streaOfArrayPart);
    }

    /**
     * When builder is used, the desired type should be additionally specified in the right part of the statement,
     * otherwise the build() method will create an instance of the Stream<Object>:
     */
    public static void streamBuilder() {
        Stream<String> streamBuilder =  Stream.<String>builder().add("b").add("u").add("i").add("l").add("d").add("e").add("r").build();
        printStream(streamBuilder);
    }

    /**
     * The next code creates a sequence of ten strings with the value “element.”
     */
    public static  void streamGenerate() {
        Stream<String> stringStream = Stream.generate(() -> "element").limit(10);
        System.out.print("Stream Generate: ");
        printStream(stringStream);
    }

    /**
     * The first element of the resulting stream is the first parameter of the iterate() method. When creating every following element,
     * the specified function is applied to the previous element. In the example next the second element will be 42.
     */
    public static void streamIterate() {
        Stream<Integer> integerStream = Stream.iterate(40, (n)-> n+2 ).limit(20);
        System.out.print("Stream Iterate: ");
        printStream(integerStream);
    }

    /**
     * Java 8 offers the possibility to create streams out of three primitive types: int, long and double. As Stream<T>
     * is a generic interface, and there is no way to use primitives as a type parameter with generics, three new special
     * interfaces were created: IntStream, LongStream, DoubleStream.
     */

    public static void streamPrimitivesIntLongDouble() {
        /*
           The range(int startInclusive, int endExclusive) method creates an ordered stream from the first parameter to
           the second parameter. It increments the value of subsequent elements with the step equal to 1. The result
           doesn’t include the last parameter, it is just an upper bound of the sequence.
         */
        IntStream integerStream = IntStream.range(1, 7);
        System.out.print("Int Stream: ");
        integerStream.forEach(System.out::print);
        System.out.println();
        /*
            The rangeClosed(int startInclusive, int endInclusive) method does the same thing with only one difference,
            the second element is included. We can use these two methods to generate any of the three types of streams
            of primitives.
         */
        LongStream longStream = LongStream.rangeClosed(1, 7);
        System.out.print("Long Stream: ");
        longStream.forEach(System.out::print);
        System.out.println();
    }

    public static void  waysCreateFlowStream() {
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

    /**
     * To convert elements of a Stream by applying a special function to them and to collect these new elements into a
     * Stream, we can use the map() method:
     */
    public static void mapCovertToPath() {
        List<String> uris = new ArrayList<>();
        uris.add("C:\\My.txt");
        uris.add("D:\\Documents\\code");

        Stream<Path> streamPath = uris.stream().map(Path::of);
    }

    public static void  testAddElementFirstArray() {
        List list = List.of(1,2,3,4,5,6,7);
        list = new ArrayList(list);

        list.add(0, list);
        printStream(Stream.of(list));

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
