package dsl.legacy;

import dsl.legacy.domain.Order;
import dsl.legacy.domain.Stock;
import dsl.legacy.domain.Trade;

public class Main {
    public static void main(final String[] args) {
        final Order order = new Order();
        order.setCustomer("BigBank");

        final Trade trade1 = new Trade();
        trade1.setType(Trade.Type.BUY);

        final Stock stock1 = new Stock();
        stock1.setSymbol("IBM");
        stock1.setMarket("NYSE");

        trade1.setStock(stock1);
        trade1.setPrice(125.00);
        trade1.setQuantity(80);

        order.addTrade(trade1);

        final Trade trade2 = new Trade();
        trade2.setType(Trade.Type.BUY);

        final Stock stock2 = new Stock();
        stock2.setSymbol("IBM");
        stock2.setMarket("NYSE");

        trade2.setStock(stock2);
        trade2.setPrice(125.00);
        trade2.setQuantity(80);

        order.addTrade(trade2);
    }
}
