package function.section1_addition;

import function.section1_addition.calculation.ICalculation;

public class CalculatorWithInjectionService {
    private ICalculation calculation;
    public CalculatorWithInjectionService(ICalculation calculation) {
        this.calculation = calculation;
    }
    public Integer calculate(Integer num1, Integer num2) {
        return calculation.calculate(num1, num2);
    }
}
