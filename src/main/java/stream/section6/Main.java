package stream.section6;

import stream.section6.domain.Product;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final long number = 1000;
        // 가우스 논제 : 1 + 2 ... 99 + 100 => ( 1 + n ) * ( n / 2) 바로 해결 가능
//        PrimitiveSum.processPrimitive(number);

//        ComplicateSum.processComplicate(number);

        ProductSum.processProductSum();

    }
}
