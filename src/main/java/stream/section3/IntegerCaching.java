package stream.section3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntegerCaching {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 3, 3, 5, 5);

        Stream<String> stream = parsingStream(numbers.stream());
        System.out.println(stream.collect(Collectors.toSet()));
//
//        stream = parsingStream(numbers.stream());
//        System.out.println(stream.collect(Collectors.joining(", ","[", "]")));
        final Integer integer1005 = 1005;
        System.out.println(
                Stream.of(1,2,3,4,5,1005)
                        .filter(i -> i ==integer1005)
                        .findFirst()
                        .orElse(0)
        );
    }
    private static final Stream<String> parsingStream(final Stream<Integer> stream){
        return stream
                .filter(i -> i > 2)
                .map(i -> i * 2)
                .map(i -> "#" + i);
    }
}
