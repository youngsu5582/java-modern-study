package dsl.legacy;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Order {

    private String customer;
    private List<Trade> trades = new ArrayList<>();

    public void addTrade(final Trade trade) {
        trades.add(trade);
    }

    public double getValue() {
        return trades.stream()
                .mapToDouble(Trade::getValue)
                .sum();
    }
}
