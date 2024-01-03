package section1_addition;

import function.section1_addition.CalculatorService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    @Test
    void 더하기_연산을_수행한다() {
        CalculatorService calculatorService = new CalculatorService();
        final Integer actualResult = calculatorService.calculate('+',1,1);

        assertEquals(actualResult,2);
    }
    @Test
    void 빼기_연산을_수행한다() {
        CalculatorService calculatorService = new CalculatorService();
        final Integer actualResult = calculatorService.calculate('-',1,1);

        assertEquals(actualResult,0);
    }
    @Test
    void 곱하기_연산을_수행한다() {
        CalculatorService calculatorService = new CalculatorService();
        final Integer actualResult = calculatorService.calculate('*',1,1);

        assertEquals(actualResult,1);
    }
    @Test
    void 나누기_연산을_수행한다() {
        CalculatorService calculatorService = new CalculatorService();
        final Integer actualResult = calculatorService.calculate('/',9,3);

        assertEquals(actualResult,3);
    }
}