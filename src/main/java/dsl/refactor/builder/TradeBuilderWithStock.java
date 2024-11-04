package dsl.refactor.builder;

import dsl.legacy.domain.Trade;

public class TradeBuilderWithStock {
    private final OrderBuilder builder;
    private final Trade trade;

    public TradeBuilderWithStock(final OrderBuilder builder, final Trade trade) {
        this.builder = builder;
        this.trade = trade;
    }

    public OrderBuilder at(final double price) {
        trade.setPrice(price);
        return builder.addTrade(trade);
    }
}
