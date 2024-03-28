package emptyList;

import java.util.ArrayList;
import java.util.List;
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

    public static void handlingNullPointerExeptionBeforeJava8() {
        List<String> nameList = getList(); // Assume getList() may return null

        //without stream
        if( nameList != null ) {
            for (String name : nameList) {
                System.out.println("Length of " + name + ": " + name.length());
            }
        }
        //Here, in the non-stream approach, we must check for null before iterating over the List to avoid a NullPointerException.
    }


    private static List<String> getList() {
        return ((int) (Math.random()*10) % 2) == 0 ? List.of("Diego", "Andrea", "Daniel", "Sara") : null;
    }
}
