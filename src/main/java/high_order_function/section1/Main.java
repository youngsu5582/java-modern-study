package high_order_function.section1;

import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Function<Function<Integer, String>, String> applyFunction = func -> func.apply(10);

        Function<Integer, String> intToString = n -> "Converted number: " + n;
        String result = applyFunction.apply(intToString);

        System.out.println(result); // 출력: Converted number: 10

        Function<Integer,Function<Integer, Integer>> f = i -> i2 -> i + i2;


        System.out.println(f.apply(1).apply(9));

        Function<Integer,Function<Integer,Function<Integer,Integer>>> f3=
                i1 -> i2 -> i3 -> i1 + i2 + i3;

        System.out.println(f3.apply(1).apply(2).apply(3));

    }
}
