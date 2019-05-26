package example.charge;


import example.Movie;
import example.MoviePriceCode;
import example.MovieRentalCondition;
import example.Rental;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RentalFeeCalculatorTest {

    @Test
    public void calculate_아동영화(){
        MovieRentalCondition condition = new MovieRentalCondition(MoviePriceCode.CHILDREN, 5);

        RentalFeeCalculator calculator = new RentalFeeCalculator();
        RentalFee rentalFee = calculator.calculate(condition);

        assertThat(rentalFee.getRentalFee()).isEqualTo(4.5);
    }

}