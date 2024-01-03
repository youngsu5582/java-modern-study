package function.section7.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import function.section7.util.CalculationUtil;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Data
public class Order {
    private Long id;
    private String orderNumber;
    private List<OrderItem> items;

    public BigDecimal totalPrice() {
        return CalculationUtil.total(items, item -> item.getItemTotal());
    }
}
