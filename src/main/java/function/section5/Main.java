package function.section5;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        final Supplier<String> helloSupplier = () -> "Hello ";
//        System.out.println(helloSupplier.get() + "world");


//        long start = System.currentTimeMillis();
//        print(-1, getVeryExpensiveValue());
//        print(0, getVeryExpensiveValue());
//        print(-2, getVeryExpensiveValue());
//
//        System.out.println("It Takes " + ((System.currentTimeMillis() - start) / 1000)+" Seconds");

        long start = System.currentTimeMillis();
        printWithSupplier(-1, () -> getVeryExpensiveValue());
        printWithSupplier(0, () -> getVeryExpensiveValue());
        printWithSupplier(-2, () -> getVeryExpensiveValue());

        System.out.println("It Takes " + ((System.currentTimeMillis() - start) / 1000) + " Seconds");


    }

    private static final String getVeryExpensiveValue() {

        //Very Expensive Calculation
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Youngsu";
    }

    private static final void printWithSupplier(Integer number, Supplier<String> valueSupplier) {
        if (number >= 0) {
            System.out.println("The value is " + valueSupplier.get() + ".");
        } else {
            System.out.println("Invalid");
        }
    }


    private static final void print(Integer number, String value) {
        if (number >= 0) {
            System.out.println("The value is " + value + ".");
        } else {
            System.out.println("Invalid");
        }
    }

}
