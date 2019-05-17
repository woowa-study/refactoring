package example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChildrenFeeCalculatorTest {
    private final double DEFAULT_DELTA = 0.01;

    @Test
    public void CHILDREN_대여기간이_4일_이상인_경우_추가_대여료가_발생한다() {
        // given
        FeeCalculator calculator = new ChildrenFeeCalculator();
        // then
        assertEquals(calculator.calculate(4), 3.0, DEFAULT_DELTA);
    }
}