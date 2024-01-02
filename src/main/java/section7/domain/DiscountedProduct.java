package section7.domain;

import lombok.ToString;

import java.math.BigDecimal;

@ToString(callSuper = true)
public class DiscountedProduct extends Product{
    public DiscountedProduct(Long id, String name, BigDecimal price) {
        super(id, name, price);
    }
}
