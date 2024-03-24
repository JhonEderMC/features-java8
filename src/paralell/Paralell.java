package paralell;

import collect.Product;

import java.util.Arrays;
import java.util.List;

/**
 * Before Java 8, parallelization was complex. The emergence of the ExecutorService and the ForkJoin
 * simplified a developer’s life a little bit, but it was still worth remembering how to create a
 * specific executor, how to run it, and so on. Java 8 introduced a way of accomplishing parallelism
 * in a functional style.
 *
 * The API allows us to create parallel streams, which perform operations in a parallel mode. When the source of a
 * stream is a Collection or an array, it can be achieved with the help of the parallelStream() method
 */
public class Paralell {

    private static List<Product> products = Arrays.asList(new Product(23, "potatoes"), new Product(14, "orange"),
            new Product(13, "lemon"), new Product(23, "bread"), new Product(13, "sugar"));

    public static void isParalell() {
        boolean isParalell = products.parallelStream().isParallel();

        System.out.println("products.parallelStream().isParallel(): "+ isParalell);
    }
}
