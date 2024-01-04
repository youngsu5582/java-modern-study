package stream.section6;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ComplicateSum {
    public static final void processComplicate(long number) {
        final long start1 = System.currentTimeMillis();
        System.out.println("Iterative Sum : " + iterativeSum(number));
        System.out.println(System.currentTimeMillis() - start1);

        final long start2 = System.currentTimeMillis();
        System.out.println("Sequential Sum : " + sequentialSum(number));
        System.out.println(System.currentTimeMillis() - start2);

        final long start3 = System.currentTimeMillis();
        System.out.println("Parallel Sum : " + parallelSum(number));
        System.out.println(System.currentTimeMillis() - start3);

        final long start4 = System.currentTimeMillis();
        System.out.println("Ranged Sum : " + rangedSum(number));
        System.out.println(System.currentTimeMillis() - start4);

        final long start5 = System.currentTimeMillis();
        System.out.println("Parallel Ranged Sum : " + parallelRangedSum(number));
        System.out.println(System.currentTimeMillis() - start5);
    }
    private static final void slowDown() {
        try {
            TimeUnit.MICROSECONDS.sleep(10L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static final long iterativeSum(long n) {
        long result = 0;
        for (long i = 0; i <= n; i++) {
            result += i;
            slowDown();
        }
        return result;
    }

    public static final long sequentialSum(long n) {
        return Stream
                .iterate(1L, i -> i + 1)
                .limit(n)
                .peek(i -> slowDown())
                .reduce(Long::sum)
                .get();
    }

    public static final long parallelSum(long n) {
        return Stream
                .iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .peek(i -> slowDown())
                .reduce(Long::sum)
                .get();
    }

    public static final long rangedSum(long n) {
        return LongStream
                .rangeClosed(1, n)
                .peek((i -> slowDown()))
                .reduce(Long::sum)
                .getAsLong();
    }

    public static final long parallelRangedSum(long n) {
        return LongStream
                .rangeClosed(1, n)
                .parallel()
                .peek(i -> slowDown())
                .reduce(Long::sum)
                .getAsLong();
    }
}
