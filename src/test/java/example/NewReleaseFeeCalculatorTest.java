package example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NewReleaseFeeCalculatorTest {
    private final double DEFAULT_DELTA = 0.01;

    @Test
    public void NEW_RELEASE_대여기간에_비례해서_대여료가_증가한다() {
        // given
        FeeCalculator calculator = new NewReleaseFeeCalculator();
        // then
        assertEquals(calculator.calculate(2), 6.0, DEFAULT_DELTA);
        assertEquals(calculator.calculate(3), 9.0, DEFAULT_DELTA);
    }

}