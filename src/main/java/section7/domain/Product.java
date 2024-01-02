package section7.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Data
public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    public static List<Product> createProductList(){
        Product productA = new Product(1L, "A", new BigDecimal("10.00"));
        Product productB = new Product(2L, "B", new BigDecimal("55.50"));
        Product productC = new Product(3L, "C", new BigDecimal("17.45"));
        Product productD = new Product(4L, "D", new BigDecimal("23.00"));
        Product productE = new Product(5L, "E", new BigDecimal("110.99"));
        Product productF = new Product(6L, "F", new BigDecimal("123.45"));

        return List.of(productA, productB, productC, productD, productE, productF);
    }

}
