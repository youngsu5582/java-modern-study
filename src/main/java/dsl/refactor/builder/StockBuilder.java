package dsl.refactor.builder;

import dsl.legacy.domain.Stock;
import dsl.legacy.domain.Trade;

public class StockBuilder {

    private final OrderBuilder builder;
    private final Trade trade;
    private final Stock stock;

    StockBuilder(final OrderBuilder builder, final Trade trade, final String symbol) {
        this.builder = builder;
        this.trade = trade;
        this.stock = new Stock();
        stock.setSymbol(symbol);
    }

    public TradeBuilderWithStock on(final String market) {
        stock.setMarket(market);
        trade.setStock(stock);
        return new TradeBuilderWithStock(builder, trade);
    }
}
