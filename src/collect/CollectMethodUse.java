package collect;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
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

    public static void toSumAll() {
        // Use stream with mapToIng and later sum
        int sumAll = products.stream().mapToInt(Product::getPrice).sum();
        System.out.println("\nproducts.stream().mapToInt(Product::getPrice).sum(): " + sumAll);
        sumAll = products.stream().collect(Collectors.summingInt(Product::getPrice));
        System.out.println("products.stream().collect(Collectors.summingInt(Product::getPrice)): " + sumAll);
    }

    /**
     * The methods averagingXX(), summingXX() and summarizingXX() can work with primitives (int, long, double) and with
     * their wrapper classes (Integer, Long, Double). One more powerful feature of these methods is providing the mapping.
     * As a result, the developer doesn’t need to use an additional map() operation before the collect() method.
     */
    public static void averagePrice() {
        // Use reduce
        float average = ((float)(products.stream().map(Product::getPrice).reduce(0, Integer::sum)) / ((float) products.size()));
        System.out.println("\nAverage Stream: ((float)(products.stream().map(Product::getPrice).reduce(0, Integer::sum)) / ((float) products.size())):  " + average);
        // Use average
        Double average1 = products.stream().collect(Collectors.averagingLong(Product::getPrice));
        System.out.print("Average Collect: products.stream().collect(Collectors.averagingLong(Product::getPrice)):  " + average1);
    }

    /**
     * By using the resulting instance of type IntSummaryStatistics, the developer can create a statistical report by
     * applying the toString() method. The result will be a String common to this one “IntSummaryStatistics{count=5, sum=86, min=13, average=17,200000, max=23}.”
     */
    public static void intSummaryStatistics() {
        IntSummaryStatistics summaryStatistics = products.stream().collect(Collectors.summarizingInt(Product::getPrice));

        System.out.println("\nIntSummaryStatistics: " + summaryStatistics);
        /*
            It is also easy to extract from this object separate values for count, sum, min, and average by applying the
            methods getCount(), getSum(), getMin(), getAverage(), and getMax(). All of these values can be extracted from a single pipeline.
         */
    }

    /**
     * Grouping of stream’s elements according to the specified function
     */
    public static void toGroupingBy() {
        Map<Integer, List<Product>> collectorMapList = products.stream().collect(Collectors.groupingBy(Product::getPrice));
        System.out.println("toGroupingBy: products.stream().collect(Collectors.groupingBy(Product::getPrice)):\n  ");

        products.forEach( product -> {
            System.out.println("Group with price: " + product.getPrice());
            List<Product> list = collectorMapList.get(product.getPrice());
            list.forEach(System.out::println);
        });


    }




}
