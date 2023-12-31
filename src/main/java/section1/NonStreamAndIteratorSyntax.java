package section1;

import java.util.List;

public class NonStreamAndIteratorSyntax implements IPrint{
    @Override
    public void printMessage(List<Integer> numbers) {
        final StringBuilder stringBuilder = new StringBuilder();

        for(Integer element : numbers){
            stringBuilder.append(element).append(" : ");
        }
        if (stringBuilder.length() > 0){
            stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length() -1);
        }
        System.out.println(stringBuilder.toString());
    }
}
