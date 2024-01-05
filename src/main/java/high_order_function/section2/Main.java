package high_order_function.section2;

import high_order_function.section2.domain.Product;
import high_order_function.section2.domain.ProductCreator;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List.of(1, 2, 3, 4, 5)
//                .forEach(System.out::println);
//                .forEach(i -> System.out.println(i));


//        List<BigDecimal> list = List.of(new BigDecimal("10.0"), new BigDecimal("23"), new BigDecimal("5"))
//                .stream()
//                .sorted(BigDecimalUtil::compare)
//                .toList();
//        System.out.println(list);
//
//        final String targetString = "c";
//        final Integer number = 5;
//        System.out.println(
//                List.of("a","b","c","d")
//                        .stream()
//                        .anyMatch(number::equals)
//        );

        final ProductCreator productCreator = Product::new;
        System.out.println(productCreator.create(1L,"A",new BigDecimal("100")));

    }

    class BigDecimalUtil{
        public static final int compare(BigDecimal bd1, BigDecimal bd2){
            return bd1.compareTo(bd2);
        }
    }
}
