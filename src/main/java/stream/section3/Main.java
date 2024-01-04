package stream.section3;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
//        IntStream.iterate(1, i -> i +1).forEach(i -> System.out.println(i + " "));

//        BigInteger unit = BigInteger.valueOf(Integer.MAX_VALUE);
//        Stream.iterate(BigInteger.ZERO, i -> i.add(unit)).forEach(i -> System.out.println(i + " "));
//        Stream<Object> stream = Stream.of(1,2,3,5);
//        stream.forEach(o -> System.out.println(o));
        final List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().toList();

        // 숫자가 3보다 크고 , 9보다 작은 값 중 숫자 * 2 의 값중 10보다 큰 가장 첫 번째 값을 구하라
//        for (final Integer number : numbers){
//            if (isSatisfaction(number)){
//                final Integer newNumber = number *2;
//                if(newNumber>10){
//                    System.out.println(newNumber);
//                    break;
//                }
//            }
//        }
//        final Integer result = numbers
//                .stream()
//                .filter(Main::isSatisfaction)
//                .map(number -> number * 2)
//                .filter(number -> number > 10)
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("Not Found!"));
//        System.out.println(result);
        final List<Integer> myOwnMethodResult =
                filter(
                        map(
                                filter(
                                        filter(numbers,
                                                i -> i > 3),
                                        i -> i < 9
                                ),
                                i -> i * 2
                        ),
                        i -> i > 10
                );
        System.out.println(myOwnMethodResult);

    }

    private static final <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate::test).toList();
    }

    private static final <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        return list.stream().map(mapper::apply).toList();
    }

    private static final Boolean isSatisfaction(final Integer number) {
        return number > 3 && number < 9;
    }
}
