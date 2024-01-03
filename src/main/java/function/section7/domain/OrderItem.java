package function.section7.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class OrderItem {
    private Long id;
    private Product product;
    private Integer quantity;
    public BigDecimal getItemTotal(){
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}
