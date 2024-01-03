package section1_addition;

import function.section1_addition.CalculatorWithInjectionService;
import org.junit.jupiter.api.Test;
import function.section1_addition.calculation.Division;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorWithInjectionServiceTest {
    @Test
    void 연산자를_주입받아_연산을_실행한다(){
        CalculatorWithInjectionService service = new CalculatorWithInjectionService(new Division());

        Integer expectedResult = service.calculate(8,2);

        assertEquals(expectedResult,4);
    }


}