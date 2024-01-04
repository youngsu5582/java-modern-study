package stream.section6;

import stream.section6.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ProductSum {
    private static final List<Product> productLists = Product.createProductList();
    private static final BigDecimal[] targetPrices = {new BigDecimal("30"), new BigDecimal("20"), new BigDecimal("31")};
    private static final Random targetPriceRandom = new Random(111);

    public static final void processProductSum() {
        test1();
        System.out.println("\n\n\n\n");
        test2();
        System.out.println("\n\n\n\n");
        test3();
    }

    private static final void test1() {
        System.out.println("========================================");
        System.out.println("\tTest1");

        for (int i = 0; i < 5; i++) {
            BigDecimal price = targetPrices[targetPriceRandom.nextInt(3)];

            imperativeTest(price);
            streamTest(price);
            streamParallelTest(price);
            System.out.println("\n");
        }
    }

    private static final void test2() {
        System.out.println("========================================");
        System.out.println("\tTest2");

        for (int i = 0; i < 5; i++) {
            BigDecimal price = targetPrices[targetPriceRandom.nextInt(3)];

            imperativeTest(price);
            streamTest(price);
            streamParallelTest(price);
        }
    }

    private static final void test3() {
        System.out.println("========================================");
        System.out.println("\tTest3");

        for (int i = 0; i < 5; i++) {
            BigDecimal price = targetPrices[targetPriceRandom.nextInt(3)];

            imperativeTest(price);
            streamTest(price);
            streamParallelTest(price);
        }
    }

    private static final void imperativeTest(final BigDecimal targetPrice) {
        System.out.println("========================================");
        System.out.println("\tImperative\n");
        final Long start = System.currentTimeMillis();
        final BigDecimal result = imperativeSum(productLists, product -> product.getPrice().compareTo(targetPrice) >= 0);
        print(result, start);
    }

    private static final void streamTest(final BigDecimal targetPrice) {
        System.out.println("========================================");
        System.out.println("\tStream\n");
        final Long start = System.currentTimeMillis();
        final BigDecimal result = streamSum(productLists.stream(), product -> product.getPrice().compareTo(targetPrice) >= 0);
        print(result, start);
    }

    private static final void streamParallelTest(final BigDecimal targetPrice) {
        System.out.println("========================================");
        System.out.println("\tStream Parallel\n");
        final Long start = System.currentTimeMillis();
        final BigDecimal result = parallelStreamSum(productLists.stream().parallel(), product -> product.getPrice().compareTo(targetPrice) >= 0);
        print(result, start);
    }

    private static final void print(BigDecimal result, Long time) {
        System.out.println("Sum: " + result);
        System.out.println("It took " + (System.currentTimeMillis() - time) + " ms.");
        System.out.println("========================================");

    }

    private static final BigDecimal imperativeSum(final List<Product> products,
                                                  final Predicate<Product> predicate) {
        BigDecimal sum = BigDecimal.ZERO;
        for (final Product product : products) {
            if (predicate.test(product)) {
                sum = sum.add(product.getPrice());
            }
        }
        return sum;
    }

    private static final BigDecimal streamSum(final Stream<Product> stream,
                                              final Predicate<Product> predicate) {
        return stream.filter(predicate).map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static final BigDecimal parallelStreamSum(final Stream<Product> stream,
                                                      final Predicate<Product> predicate) {
        return streamSum(stream.parallel(), predicate);
    }

}
