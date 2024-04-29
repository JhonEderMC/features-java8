package emptyStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * In this short tutorial, we’ll have a quick look at intermediate and terminal operations in Java Streams, some of the
 * ways of creating an empty Stream, and how to check for an empty Stream.
 */
public class EmptyStream {
    /**
     * Sometimes, we may need to pass a Stream as a parameter to methods or return one from a method. An empty Stream is
     * useful to handle NullPointerExceptions. Moreover, some of the Stream operations, such as findFirst(), findAny(),
     * min(), and max(), check for empty Stream and return the results accordingly.
     *
     * There are multiple ways of creating Streams. Consequently, there’re multiple ways to create an empty Stream too.
     */

    /**
     * we can simply use the empty() method of class Stream:
     */
    public static void streamEmpty() {
        Stream<String> emptystream = Stream.empty();
        //The empty() method returns an empty sequential Stream of type String.
        System.out.println("Stream.empty(): " + emptystream + " isEmpty: " + (emptystream.findAny().isEmpty()));
    }

    /**
     * We can also create an empty Stream of any type using the of() method. The of() method returns a sequential
     * ordered Stream containing the elements that are passed as parameters to it. If we don’t pass any parameter,
     * it returns an empty Stream:
     */
    public static void streamOf() {
       Stream<String> streamEmpty = Stream.of();
       System.out.println("Stream.of(): " + streamEmpty + "isEmpty: " + streamEmpty.findAny().isEmpty() );
    }

    /**
     * we can create a Stream of primitive types using IntStream:
     */
    public static void intStream() {
        IntStream empty = IntStream.empty();
        System.out.println("InStream.empty(): " + empty + " isEmpty: " + empty.findAny().isEmpty());

        //we can create a Stream of primitive types using IntStream
        Stream<int[]> emptyInt = Stream.of(new int[]{});
        System.out.println("Stream.of(new int[]{}): " + emptyInt + " isEmpty: " + emptyInt.findAny().isEmpty());

        /*
         The Arrays class has a method stream() that accepts an array as a parameter and returns a Stream of the same
         type as that of the parameter. We can use this to create an empty Stream by passing an empty array as a parameter
         */
        IntStream intStreamEmpty = Arrays.stream(new int[]{});
        System.out.println("Arrays.stream(new int[]{}): " + intStreamEmpty + " isEmpty: " + intStreamEmpty.findAny().isEmpty());

        /*
        Finally, we can use the stream() method of a Collection such as a List or Set to create an empty Stream. An
        empty collection would create an empty Stream
         */
        Stream<Integer> emptyIntSream = new ArrayList<Integer>().stream();
        System.out.println("new ArrayList<Integer>().stream(): " + emptyIntSream + " isEmpty: " + emptyIntSream.findAny().isEmpty());
    }


}
