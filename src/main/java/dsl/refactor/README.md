# 느낀점

따라치며 느낀점으론 매우 어렵다.
무작정 만들면, 없는것 보다 못함을 느꼈다. 

OrderBuilder 는 제일 처음 주문 생성을 담당한다.
1. forCustomer 를 통해 Customer 를 설정한다.
( 다시, 자신을 반환한다. )

2. 그 후, buy / sell 을 호출한다.
OrderBuilder 는 그러면, TradeBuilder 를 반환한다.

이때
```java
public TradeBuilder buy(final int quantity) {
    return new TradeBuilder(this, Trade.Type.BUY, quantity);
}
```
이와같이 Trade TYPE 을 자동으로 결정한다.

3. 주식명(stock) 을 지정한다.
TradeBuilder 는 StockBuilder 를 반환한다.

4. 마켓명(on) 을 지정한다.

StockBuilder 는 내부에 Stock 을 가질 수 밖에 없다.
- 생성자 일때는 symbol 을 포함
- on 일때는 마켓 지정

```java
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
```

Stock 을 가진 TradeBuilderWithStock 을 만든다.

5. at 을 통해 가격을 지정한다.

지정후, 다시 OrderBuilder 를 반환해서 1~5 과정을 반복할 수 있다.

## 좋은가?

좋아 보이긴 하나, 이게 팀 단위로 도입이 될 때 효과가 있을지는 궁금하다.

DSL 의 약자는 Domain-Specific-Language 이다.
말 그대로, 도메인 전용 언어이다.

각자 프로젝트 내 도메인은 다를것이다.
팀 내, 그리고 사용하는 사람들이 얼마나 편하게 `+` 이해하기 쉬운지가 관건이다.

토스와 우형에서는 DSL 을 도입하고 있는 부분들이 존재한다.
이도 MSA 와 비슷한 개념이 아닐까 생각이 든다.
( 도입이 정말 필요한지, 이게 더 좋을지에 대해 생각 )
