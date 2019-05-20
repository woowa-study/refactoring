package example;


import example.movie.ChildrenMovie;
import example.movie.Movie;
import example.rental.Rental;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class CustomerTest {

    @Test
    public void customerTest() {
        Customer customer = new Customer("미현");

        Movie movie = new ChildrenMovie("왕범식");
        Rental rental = new Rental(movie, 7);

        customer.addRental(rental);
        String result = customer.statement();
        log.info(result);
        assertThat(result).contains("누적 대여료 : 7.5적립 포인트 : 1");
    }

}
