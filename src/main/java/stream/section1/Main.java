package stream.section1;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        final Integer abs1 = Math.abs(-1);
        final Integer abs2 = Math.abs(1);

        System.out.println(abs1);
        System.out.println(abs2);

        final Integer minInt = Integer.MIN_VALUE;

        // -2147483648 : Signed Integer
        // 최대 : 2147483647
        // 최소 : -2147483648
        // => 즉 , 최소값의 절대값은 나올수 없으므로 -> -2147483648
        System.out.println(Math.abs(minInt));

        BigInteger bigInteger = BigInteger.valueOf(minInt);

        System.out.println(bigInteger.abs());
    }
}
