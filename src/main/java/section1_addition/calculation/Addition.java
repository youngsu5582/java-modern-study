package section1_addition.calculation;

public class Addition implements ICalculation{
    @Override
    public Integer calculate(Integer num1, Integer num2) {
        return num1 + num2;
    }
}
