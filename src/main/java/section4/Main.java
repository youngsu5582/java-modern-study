package section4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> isPositiveWithPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%2 ==0;
            }
        };
        Predicate<Integer> isPositiveWithLambda = (element) -> element%2 ==0;
        Function<Integer,Boolean> isPositiveWithFunction = new Function<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer integer) {
                return integer %2 ==0;
            }
        };
        List<Integer> numbers = List.of(-5,-4,-3,-2,-1,0,1,2,3,4,5);

        Predicate<Integer> isPositive = (element) -> element%2 ==0;
        List<Integer> positiveNumbers = new ArrayList<>();
        for(Integer num : numbers){
            if(isPositive.test(num)){
                positiveNumbers.add(num);
            }
        }
        Predicate<Integer> isLessThan3 = i -> i<3;
        List<Integer> numbersLessThan3 = new ArrayList<>();
        for(Integer num : numbers){
            if(isLessThan3.test(num)){
                numbersLessThan3.add(num);
            }
        };
        System.out.println(positiveNumbers);
        System.out.println(numbersLessThan3);

        System.out.println(filter(numbers,isPositive));
        System.out.println(filter(numbers,isLessThan3));
    }
    private static<T> List<T> filter(List<T> list , Predicate<T> filter){
        List<T> result = new ArrayList<>();
        for(T element : list){
            if(filter.test(element)){
                result.add(element);
            }
        }
        return result;
    }
}
