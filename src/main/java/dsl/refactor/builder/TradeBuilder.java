package dsl.refactor.builder;

import dsl.legacy.domain.Trade;

public class TradeBuilder {
    private final OrderBuilder builder;
    private final Trade trade;

    TradeBuilder(final OrderBuilder builder, final Trade.Type type, final int quantity) {
        this.builder = builder;
        this.trade = new Trade();
        trade.setType(type);
        trade.setQuantity(quantity);
    }

    public StockBuilder stock(final String symbol){
        return new StockBuilder(builder,trade,symbol);
    }
}
