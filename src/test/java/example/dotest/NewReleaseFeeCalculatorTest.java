package example.dotest;

import org.junit.Test;

import static common.TestConstant.DEFAULT_DELTA;
import static org.junit.Assert.assertEquals;

public class NewReleaseFeeCalculatorTest {

    @Test
    public void NEW_RELEASE_대여기간에_비례해서_대여료가_증가한다() {
        // given
        FeeCalculator calculator = new NewReleaseFeeCalculator();
        // then
        assertEquals(calculator.calculate(2), 6.0, DEFAULT_DELTA);
        assertEquals(calculator.calculate(3), 9.0, DEFAULT_DELTA);
    }

}