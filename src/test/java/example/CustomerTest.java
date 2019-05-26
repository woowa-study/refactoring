package example;

import example.formatter.RentalHistoryAsStringFormatter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
@Slf4j
public class CustomerTest {
    @Test
    public void statement_2() {
        Customer customer = new Customer("홍길동");
        Movie movie = new Movie("아동영화", MoviePriceCode.CHILDREN);
        Rental rental = new Rental(movie, 5);
        customer.addRental(rental);

        Movie movie2 = new Movie("신작영화", MoviePriceCode.NEW_RELEASE);
        Rental rental2 = new Rental(movie2, 5);
        customer.addRental(rental2);

        String result = customer.statement_2();
        customer.addRental(rental2);
        log.warn("result {}",result);
        assertThat(result).contains("홍길동 고객님의 대여 기록");
        double childMovieRentFee = 4.5, newReleaseMovieRentFee = 15.0;
        int childMoviePoint = 1, newReleaseMoviePoint = 2;
        assertThat(result).contains("아동영화\t"+ childMovieRentFee);
        assertThat(result).contains("신작영화\t"+ newReleaseMovieRentFee);
        assertThat(result).contains("누적 대여료 : "+(childMovieRentFee+newReleaseMovieRentFee));
        assertThat(result).contains("적립 포인트 : "+(childMoviePoint + newReleaseMoviePoint));

    }
}