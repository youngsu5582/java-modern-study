package section3;

import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        final Consumer<String> printHelloWithConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Hello : " + s);
            }
        };
        printHelloWithConsumer.accept("Youngsu");


        final Consumer<String> printByeWithLambda = (element) -> System.out.println("Bye : "+element);
        printByeWithLambda.accept("Youngsu");

    }
}
