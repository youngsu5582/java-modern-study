package section1;

import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        final List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().toList();
        IPrint instance = new StreamSyntax();
//        IPrint instance = new NonStreamAndIteratorSyntax();
//        IPrint instance = new NonStreamAndForSyntax();
        instance.printMessage(numbers);

    }
}