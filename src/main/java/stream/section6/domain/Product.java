package stream.section6.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@AllArgsConstructor
@Data
public class Product {
    private Long id;
    private String name;
    private BigDecimal price;


    public static List<Product> createProductList() {
        final List<String> priceStrings = List.of("1.0", "100.99", "35.75", "21.30", "88.00");
        final Random random = new Random(123);
        final Integer length = 8_000_000;
        final List<Product> list = new ArrayList<>();
        IntStream.range(0, length)
                .forEach(
                        i -> list.add(new Product(
                                (long) i,
                                "Product" + i,
                                new BigDecimal(priceStrings.get(random.nextInt(5))))));
        return list;
    }
}
