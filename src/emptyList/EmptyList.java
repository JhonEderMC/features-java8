package emptyList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmptyList {


    public static void emptyListToStream() {
        List<String> emptyList = new ArrayList<>();
        Stream<String> emptyStream = emptyList.stream();
        /*
            This enables us to perform various Stream operations on an empty List just as on a non-empty List. However,
            we must note that the result of the operation could be empty since the source of the Stream is empty.
         */
    }

    public static void handlingNullPointerExceptionBeforeJava8() {
        List<String> nameList = getList(); // Assume getList() may return null
        System.out.println("Management previous java 8");
        //without stream
        if( nameList != null ) {
            for (String name : nameList) {
                System.out.println("Length of " + name + ": " + name.length());
            }
        }
        //Here, in the non-stream approach, we must check for null before iterating over the List to avoid a NullPointerException.
    }

    /**
     * On the other hand, using Optional and Stream, we can perform a long chain of operations without specifically handling
     * the null checks and also avoiding NullPointerException
     */
    public static void handlingNullPointerException() {
        List<String> nameList = getList(); // Assume getList() may return null
        System.out.println("Management Streams");

        Optional.ofNullable(nameList)
                .ifPresent(list -> list.stream()
                        .map(name -> "Length of " + name + ": " + name.length())
                        .forEach(System.out::println)
                );
    }


    private static List<String> getList() {
        return ((int) (Math.random()*10) % 2) == 0 ? List.of("Diego", "Andrea", "Daniel", "Sara") : null;
    }

    public static void collectingStreamOfEmptyListIntoList() {
        List<String> emptyList = new ArrayList<>();
        List<String> collectedList = emptyList.stream().collect(Collectors.toList());
        System.out.println("List<String> emptyList = new ArrayList<>();\n" +
                "        List<String> collectedList = emptyList.stream().collect(Collectors.toList()); " + collectedList);
        //Here, collect() is a terminal operation, and it performs mutable reduction on the elements of the Stream.
    }

    /**
     * Similarly, performing an intermediate operation such as filter() and collecting the result in any collection would result in an empty Stream:
     */
    public static void collectingStreamOfEmptyListIntoList2() {
        List<String> emptyList = new ArrayList<>();
        List<String> collectdList = emptyList.stream().filter(string ->  string.contains("a"))
                .collect(Collectors.toList());
        System.out.println("emptyList.stream().filter(string ->  string.contains(\"a\"))\n" +
                "                .collect(Collectors.toList()); " + collectdList);
    }

}
