package dsl.refactor;

import dsl.legacy.domain.Order;

import static dsl.refactor.builder.OrderBuilder.forCustomer;

public class Main {
    public static void main(final String[] args) {
        final Order order = forCustomer("BigBank")
                .buy(80)
                .stock("IBM")
                .on("NYSE")
                .at(125.00)
                .sell(50)
                .stock("GOOGLE")
                .on("NASDAQ")
                .at(375.00)
                .end();
    }
}
