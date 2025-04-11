package ro.ulbs.paradigme.lab7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ro.ulbs.paradigme.lab6.NewIntCalculator;

public class NewIntCalculatorTest {

    @Test
    public void testAdd() {
        // Arrange
        NewIntCalculator calc = new NewIntCalculator(5);
        // Act
        calc.add(3);
        // Assert
        Assertions.assertEquals(8, calc.getState());
    }

    @Test
    public void testSubtract() {
        NewIntCalculator calc = new NewIntCalculator(10);
        calc.subtract(4);
        Assertions.assertEquals(6, calc.getState());
    }

    @Test
    public void testMultiply() {
        NewIntCalculator calc = new NewIntCalculator(3);
        calc.multiply(7);
        Assertions.assertEquals(21, calc.getState());
    }

    @Test
    public void testDivide() {
        NewIntCalculator calc = new NewIntCalculator(20);
        calc.divide(4);
        Assertions.assertEquals(5, calc.getState());
    }

    @Test
    public void testInit() {
        NewIntCalculator calc = new NewIntCalculator(100);
        calc.init();
        Assertions.assertEquals(0, calc.getState());
    }

    @Test
    public void testDivideByZero() {
        NewIntCalculator calc = new NewIntCalculator(10);
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calc.divide(0);
        });
    }
}
