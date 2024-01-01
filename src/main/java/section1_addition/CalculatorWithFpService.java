package section1_addition;

import section1_addition.calculation.ICalculation;

public class CalculatorWithFpService {
    public Integer calculate(ICalculation calculation,Integer num1, Integer num2){
        return calculation.calculate(num1,num2);
    }
}
