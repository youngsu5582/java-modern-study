package function.section1_addition;

public class CalculatorService {
    public Integer calculate(Character calculation, int num1, int num2) {
        if (calculation.equals('+')) {
            return num1 + num2;
        } else if (calculation.equals('-')) {
            return num1 - num2;
        } else if (calculation.equals('*')) {
            return num1 * num2;
        } else if (calculation.equals('/')){
            return num1 / num2;
        }
        throw new IllegalArgumentException("Not Exist Calculation");
    }
}
