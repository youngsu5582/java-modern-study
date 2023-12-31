package section1;

import java.util.List;

public class NonStreamAndForSyntax implements IPrint{
    @Override
    public void printMessage(List<Integer> numbers) {
        final StringBuilder stringBuilder = new StringBuilder();
        Integer size = numbers.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(numbers.get(i));
            if (i != size - 1) {
                stringBuilder.append(" : ");
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
