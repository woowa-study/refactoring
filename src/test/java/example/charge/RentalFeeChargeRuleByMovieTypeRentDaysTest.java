package example.charge;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RentalFeeChargeRuleByMovieTypeRentDaysTest {

    @Test
    public void calculate() {
        double result = RentalFeeChargeRuleByMovieTypeRentDays.calculate(5, 1.5,3);
        assertThat(result).isEqualTo(4.5);
    }
}