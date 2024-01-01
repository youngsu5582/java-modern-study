package section2;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Function<String,Integer> toInteger = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };
        System.out.println(toInteger.apply("5"));

        Function<String,Integer> function = (element) -> Integer.parseInt(element);
        Integer number = function.apply("10");
        System.out.println(number);

//        final Function<Integer,Integer> identity = Function.identity();
//        System.out.println(identity.apply(999));

        final Function<Integer,Integer> identity = t -> t;
        System.out.println(identity.apply(20));
    }
}
