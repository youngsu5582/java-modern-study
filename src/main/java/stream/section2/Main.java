package stream.section2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println(
                mapOld(numbers, i -> i * 2)
        );
        System.out.println(
                mapOld(numbers, null)
        );
        System.out.println(
                map(numbers, i -> i * 2)
        );
        System.out.println(
                map(numbers,i -> i)
        );
        System.out.println(
                map(numbers, Function.identity())
        );
    }

    private static final <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        final List<R> result = new ArrayList<>();
        for (final T t : list) {
            result.add(mapper.apply(t));
        }
        return result;
    }

    private static final <T, R> List<R> mapOld(List<T> list, Function<T, R> mapper) {
        if (mapper == null) {
            return new ArrayList<>((List<R>) list);
        }
        final List<R> result = new ArrayList<>();

        for (final T t : list) {
            result.add(mapper.apply(t));
        }
        return result;
    }

}
