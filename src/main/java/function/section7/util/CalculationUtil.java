package function.section7.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;


public interface CalculationUtil {
    public static <T> BigDecimal total(List<T> list, Function<T, BigDecimal> mapper) {
        BigDecimal total = BigDecimal.ZERO;
        for (final T t : list) {
            total = total.add(mapper.apply(t));
        }
        return total;
    }
}
