package high_order_function.section2.domain;

import java.math.BigDecimal;

@FunctionalInterface
public interface ProductCreator {
    Product create(Long id, String name, BigDecimal price);
}