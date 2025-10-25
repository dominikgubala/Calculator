package pl.dominikgubala.advancedprogramming2.calculator;

import org.junit.jupiter.api.Test;
import pl.dominikgubala.advancedprogramming2.calculator.model.CalculatorModel;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private final CalculatorModel calculator = new CalculatorModel();

    @Test
    public void additionTest() {
        double result = calculator.add(1, 2);
        assertEquals(3, result);
    }

    @Test
    public void subtractionTest() {
        double result = calculator.subtract(5, 4);
        assertEquals(1, result);
    }

    @Test
    public void multiplicationTest() {
        double result = calculator.multiply(9, 9);
        assertEquals(81, result);
    }

    @Test
    public void divisionTest() {
        double result = calculator.divide(42, 7);
        assertEquals(6, result);
    }
}
