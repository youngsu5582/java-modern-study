package dsl.refactor.builder;

import dsl.legacy.domain.Order;
import dsl.legacy.domain.Trade;

public class OrderBuilder {
    private final Order order;

    private OrderBuilder(final String customer) {
        this.order = new Order();
        order.setCustomer(customer);
    }

    public static OrderBuilder forCustomer(final String customer) {
        return new OrderBuilder(customer);
    }

    public TradeBuilder buy(final int quantity) {
        return new TradeBuilder(this, Trade.Type.BUY, quantity);
    }

    public TradeBuilder sell(final int quantity) {
        return new TradeBuilder(this, Trade.Type.SELL, quantity);
    }

    protected OrderBuilder addTrade(final Trade trade) {
        order.addTrade(trade);
        return this;
    }

    public Order end() {
        return order;
    }
}
