package section1;

import java.util.List;
import java.util.stream.Collectors;

public class StreamSyntax implements IPrint{
    @Override
    public void printMessage(List<Integer> numbers) {
        final String result = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" : "))
                .toString();

        System.out.println(result);
    }
}
