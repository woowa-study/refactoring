package kyunam;

import kyunam.customer.Customer;
import kyunam.movie.Movie;
import kyunam.movie.MovieType;
import kyunam.rental.Rental;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
public class CustomerTest {

    @Test
    public void customerTest() {
        Customer customer = new Customer("미현");

        Movie movie = new Movie("왕범식", MovieType.CHILDREN);
        Rental rental = new Rental(movie, 7);

        customer.addRental(rental);
        String result = customer.statement();
        log.info(result);
        assertThat(result).contains("누적 대여료 : 7.5적립 포인트 : 1");
    }

}
