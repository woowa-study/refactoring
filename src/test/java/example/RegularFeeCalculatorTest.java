package example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegularFeeCalculatorTest {
    private final double DEFAULT_DELTA = 0.01;

    @Test
    public void REGULAR_대여기간이_3일_이상인_경우_추가_대여료가_발생한다() {
        // given
        FeeCalculator calculator = new RegularFeeCalculator();
        // then
        assertEquals(calculator.calculate(3), 3.5, DEFAULT_DELTA);
    }
}