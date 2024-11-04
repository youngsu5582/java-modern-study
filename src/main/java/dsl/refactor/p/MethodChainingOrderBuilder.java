package dsl.refactor.p;

import dsl.legacy.Order;
import dsl.legacy.Trade;

public class MethodChainingOrderBuilder {
    private final Order order;

    private MethodChainingOrderBuilder(final String customer) {
        this.order = new Order();
        order.setCustomer(customer);
    }

    public static MethodChainingOrderBuilder forCustomer(final String customer) {
        return new MethodChainingOrderBuilder(customer);
    }

    public TradeBuilder buy(final int quantity) {
        return new TradeBuilder(this, Trade.Type.BUY, quantity);
    }

    public TradeBuilder sell(final int quantity) {
        return new TradeBuilder(this, Trade.Type.SELL, quantity);
    }

    protected MethodChainingOrderBuilder addTrade(final Trade trade) {
        order.addTrade(trade);
        return this;
    }

    public Order end() {
        return order;
    }
}
