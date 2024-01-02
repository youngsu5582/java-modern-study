package section7;

import java.math.BigDecimal;

@FunctionalInterface
public interface BigDecimalToCurrency {
    String toCurrency(BigDecimal value);
}
