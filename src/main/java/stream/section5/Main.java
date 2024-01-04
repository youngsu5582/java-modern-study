package stream.section5;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","8");

        //Stream Sum ( side-effect )
//        final int[] num1 = {0};
//        IntStream.range(0,10000)
//                .forEach(i -> num1[0] +=i);
//        System.out.println(num1[0]);

        // Parallel sum ( side-effect )
//        final int[] num2 = {0};
//        IntStream.range(0,10000)
//                .parallel()
//                .forEach(i -> num2[0] +=i);
//        System.out.println(num2[0]);

        //Stream Sum ( no side-effect )
//        System.out.println(IntStream.range(0, 10000).sum());

        // Parallel Sum ( no side-effect )
//        System.out.println(IntStream.range(0,10000).parallel().sum());
//========================================================================================
        // Non - Parallel 8 Element
//        final long start1 = System.currentTimeMillis();
//        List.of(1,2,3,4,5,6,7,8)
//                .stream()
//                .map(i->{
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return i;
//                })
//                .forEach(System.out::println);
//        System.out.println(System.currentTimeMillis() - start1);

//========================================================================================
        // Parallel 8 Element
//        final long start2 = System.currentTimeMillis();
//        List.of(1,2,3,4,5,6,7,8)
//                .parallelStream()
//                .map(i->{
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return i;
//                })
//                .forEach(System.out::println);
//        System.out.println(System.currentTimeMillis() - start2);

//========================================================================================

        // Parallel 9 Element
//        final long start3 = System.currentTimeMillis();
//        List.of(1,2,3,4,5,6,7,8,9)
//                .parallelStream()
//                .map(i->{
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return i;
//                })
//                .forEach(System.out::println);
//        System.out.println(System.currentTimeMillis() - start3);


//========================================================================================

        // Parallel 8 Element , with parallelism core 1
//        final long start4 = System.currentTimeMillis();
//        List.of(1,2,3,4,5,6)
//                .parallelStream()
//                .map(i->{
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return i;
//                })
//                .forEach(System.out::println);
//        System.out.println(System.currentTimeMillis() - start4);

//========================================================================================

        // In Complicated Case
//        final long start3 = System.currentTimeMillis();
//        IntStream.range(0, 512).boxed().toList()
//                .parallelStream()
//                .map(i -> {
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return i;
//                })
//                .forEach(System.out::println);
//        System.out.println(System.currentTimeMillis() - start3);
    }
}
