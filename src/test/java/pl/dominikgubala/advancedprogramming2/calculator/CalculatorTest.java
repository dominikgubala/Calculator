package pl.dominikgubala.advancedprogramming2.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    public void additionTest() {
        double result = calculator.addition(1, 2);
        assertEquals(3, result);
    }

    @Test
    public void subtractionTest() {
        double result = calculator.subtraction(5, 4);
        assertEquals(1, result);
    }

    @Test
    public void multiplicationTest() {
        double result = calculator.multiplication(9, 9);
        assertEquals(81, result);
    }

    @Test
    public void divisionTest() {
        double result = calculator.division(42, 7);
        assertEquals(6, result);
    }
}
