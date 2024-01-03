package function.section7;

import function.section7.domain.DiscountedProduct;
import function.section7.domain.Order;
import function.section7.domain.OrderItem;
import function.section7.domain.Product;
import function.section7.util.CalculationUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
//        BigDecimalToCurrency bigDecimalToCurrency = bd -> "$" + bd.toString();
//        System.out.println(bigDecimalToCurrency.toCurrency(BigDecimal.valueOf(100000)));
//
//        final InvalidFunctionInterface<String> invalidFunctionInterface = value -> value.toString();
//        System.out.println(invalidFunctionInterface.mkString("5"));


        final List<Product> sampleProducts = Product.createProductList();
        final BigDecimal twenty = new BigDecimal(20);
        List<Product> result = filter(sampleProducts, product -> product.getPrice().compareTo(twenty) > 0);
        System.out.println(result);

        System.out.println(filter(sampleProducts, product -> product.getPrice().compareTo(new BigDecimal("10")) <= 0));

        final List<Product> expensiveProducts = filter(sampleProducts, product -> product.getPrice().compareTo(new BigDecimal("50")) > 0);

        final List<DiscountedProduct> discountedProduct =
                map(
                        expensiveProducts, product ->
                                new DiscountedProduct(
                                        product.getId(),
                                        product.getName(),
                                        product.getPrice().
                                                multiply(new BigDecimal("0.5"))));

        System.out.println(discountedProduct);

        final Predicate<Product> lessThanOrEqual30 = product -> product.getPrice().compareTo(new BigDecimal("30")) <= 0;
        System.out.println(filter(discountedProduct, lessThanOrEqual30));
        System.out.println(filter(sampleProducts, lessThanOrEqual30));

        final BigDecimal total = CalculationUtil.total(sampleProducts, product -> product.getPrice());
        System.out.println("total : " + total);

        Order order = new Order(1L, "order-1234", List.of(
                new OrderItem(1L, sampleProducts.get(0), 2),
                new OrderItem(2L, sampleProducts.get(1), 1),
                new OrderItem(3L, sampleProducts.get(2), 10)
                ));
        System.out.println(order.totalPrice());
    }

    private static final <T> List<T> filter(List<T> list, Predicate<? super T> predicate) {
        final List<T> result = new ArrayList<>();
        for (final T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    private static final <T, R> List<R> map(List<T> list, Function<T, R> function) {
        final List<R> result = new ArrayList<>();
        for (final T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }
}
