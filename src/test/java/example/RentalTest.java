package example;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RentalTest {

    @Test
    public void calculateRentFee() {
        Movie movie = new Movie("아동영화", MoviePriceCode.CHILDREN);
        Rental rental = new Rental(movie, 5);
        double result = rental.calculateRentFee();
        assertThat(result).isEqualTo(4.5);
    }

    @Test
    public void calculatePoint() {
        Movie movie = new Movie("아동영화", MoviePriceCode.CHILDREN);
        Rental rental = new Rental(movie, 5);
        double result = rental.calculatePoint();
        assertThat(result).isEqualTo(1);
    }
}