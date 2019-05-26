package example.point;


import example.MoviePriceCode;
import example.MovieRentalCondition;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointCalculatorTest {

    @Test
    public void calculate() {
        MovieRentalCondition condition = new MovieRentalCondition(MoviePriceCode.CHILDREN, 5);
        PointCalculator calculator = new PointCalculator();
        Point point = calculator.calculate(condition);
        assertThat(point.getPoint()).isEqualTo(1);
    }
}