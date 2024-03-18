package collect;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The reduction of a stream can also be executed by another terminal operation, the collect() method. It accepts an
 * argument of the type Collector, which specifies the mechanism of reduction. There are already created,
 * predefined collectors for most common operations. They can be accessed with the help of the Collectors type.
 */
public class CollectMethodUse {

    private static List<Product> products = Arrays.asList(new Product(23, "potatoes"), new Product(14, "orange"),
            new Product(13, "lemon"), new Product(23, "bread"), new Product(13, "sugar"));

    public static void toListString() {
        List<String> productNames = products.stream().map(Product::getName).collect(Collectors.toList());

        System.out.print("products.stream().map(Product::getName).collect(Collectors.toList()):  ");
        productNames.forEach(productName -> System.out.print(" - " + productName));
    }

    public static void toListStringJoining() {
        String listString = products.stream().map(Product::getName).collect(Collectors.joining(",", "[", "]"));

        System.out.println("\nproducts.stream().map(Product::getName).collect(Collectors.joining(\",\", \"[\", \"]\")):  " + listString);
    }

    public static void toListPrice() {
        List<Integer> prices = products.stream().map(Product::getPrice).collect(Collectors.toList());
        System.out.print("products.stream().map(Product::getPrice).collect(Collectors.toList()): ");

        prices.forEach(price -> System.out.print("  "+ price));
    }




}
