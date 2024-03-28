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


}
