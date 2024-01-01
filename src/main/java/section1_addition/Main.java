package section1_addition;

import section1_addition.calculation.Addition;
import section1_addition.calculation.Division;
import section1_addition.calculation.ICalculation;

public class Main {
    public static void main(String[] args){
        final CalculatorService calculatorService = new CalculatorService();
        try{
              //OOP
            final Integer additionResult = calculatorService.calculate('+',1,1);
            System.out.println(additionResult);
            final Integer subtractionResult = calculatorService.calculate('-',1,1);
            System.out.println(subtractionResult);
            final Integer multiResult = calculatorService.calculate('*',1,1);
            System.out.println(multiResult);
            final Integer divisionResult = calculatorService.calculate('*',1,1);
            System.out.println(divisionResult);

            CalculatorWithInjectionService service = new CalculatorWithInjectionService(new Addition());
            System.out.println(service.calculate(5,3));


              //FP
            CalculatorWithFpService calculatorWithFpService = new CalculatorWithFpService();
            System.out.println(calculatorWithFpService.calculate(new Division(),20,4));

            ICalculation addition = (num1, num2) -> num1+num2;
            System.out.println(calculatorWithFpService.calculate(addition,11,4));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
