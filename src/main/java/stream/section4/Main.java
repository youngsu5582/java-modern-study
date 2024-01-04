package stream.section4;


import stream.section4.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        final List<Product> products = Product.createProductList();
        System.out.println(
                products
                        .stream()
                        .filter(
                                product -> product
                                        .getPrice()
                                        .compareTo(new BigDecimal("30")) >= 0)
                        .toList()
        );
        System.out.println(
                products
                        .stream()
                        .filter(
                                product -> product
                                        .getPrice()
                                        .compareTo(new BigDecimal("30")) >= 0)
                        .map(Product::toString)
                        .collect(Collectors.joining("\n"))
        );
        System.out.println(
                products
                        .stream()
                        .map(Product::getPrice)
                        .reduce(BigDecimal.ZERO, (pastDecimal, newDecimal) -> pastDecimal.add(newDecimal))
        );

    }
}
