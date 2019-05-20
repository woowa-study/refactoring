package example.dotest;

import example.dotest.FeeCalculator;
import example.dotest.RegularFeeCalculator;
import org.junit.Test;

import static common.TestConstant.DEFAULT_DELTA;
import static org.junit.Assert.assertEquals;

public class RegularFeeCalculatorTest {

    @Test
    public void REGULAR_대여기간이_3일_이상인_경우_추가_대여료가_발생한다() {
        // given
        FeeCalculator calculator = new RegularFeeCalculator();
        // then
        assertEquals(calculator.calculate(3), 3.5, DEFAULT_DELTA);
    }
}