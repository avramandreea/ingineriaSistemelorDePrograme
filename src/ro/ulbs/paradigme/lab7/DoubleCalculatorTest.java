package ro.ulbs.paradigme.lab7;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ro.ulbs.paradigme.lab6.DoubleCalculator;

public class DoubleCalculatorTest {

    @Test
    public void testAdd() {
        DoubleCalculator calc = new DoubleCalculator(5.5);
        calc.add(4.5);
        Assertions.assertEquals(10.0, calc.getState());
    }

    @Test
    public void testSubtract() {
        DoubleCalculator calc = new DoubleCalculator(10.0);
        calc.subtract(3.5);
        Assertions.assertEquals(6.5, calc.getState());
    }

    @Test
    public void testMultiply() {
        DoubleCalculator calc = new DoubleCalculator(2.0);
        calc.multiply(4.5);
        Assertions.assertEquals(9.0, calc.getState());
    }

    @Test
    public void testDivide() {
        DoubleCalculator calc = new DoubleCalculator(9.0);
        calc.divide(3.0);
        Assertions.assertEquals(3.0, calc.getState());
    }

    @Test
    public void testInit() {
        DoubleCalculator calc = new DoubleCalculator(100.0);
        calc.init();
        Assertions.assertEquals(0.0, calc.getState());
    }

    @Test
    public void testDivideByZero() {
        DoubleCalculator calc = new DoubleCalculator(10.0);
        calc.divide(0.0);
        Assertions.assertTrue(

                Double.isInfinite((double) calc.getState()) ||

                        Double.isNaN((double) calc.getState())


        );
    }
}
