package paralell;

import collect.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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

    public static void bigPrice() {
        boolean bigPrice = products.parallelStream().map(product -> product.getPrice()*12).anyMatch( price -> price > 200);
        System.out.println("products.parallelStream().map(product -> product.getPrice()*12).anyMatch( price -> price > 200): " + bigPrice);
    }

    /**
     * If the source of a stream is something other than a Collection or an array, the parallel() method should be used
     */
    public static void intStreamParalell() {
        IntStream intStream = IntStream.range(1,150).parallel();
        boolean isParalell = intStream.isParallel();

        System.out.println("IntStream intStream = IntStream.range(1,150).parallel();\n" +
                "        boolean isParalell = intStream.isParallel();");
        System.out.println("isParalell: " + isParalell);
    }

    public static void sequential() {
        IntStream intStream = IntStream.range(1, 150).parallel();
        IntStream intSequential = intStream.sequential();
        boolean isParalell = intSequential.isParallel();

        System.out.println("IntStream intStream = IntStream.range(1, 150).parallel();\n" +
                "        IntStream intSequential = intStream.sequential();\n" +
                "        boolean isParalell = intSequential.isParallel();");
        System.out.println("isParalell: " + isParalell);
    }
}
