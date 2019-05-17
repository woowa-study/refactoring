package example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Movie regular = new Movie("정규 영화", Movie.Type.REGULAR);
    private Movie newRelease = new Movie("신규 영화", Movie.Type.NEW_RELEASE);
    private Movie children = new Movie("어린이 영화", Movie.Type.CHILDREN);
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("고객");
    }

    @Test
    public void statement_테스트() {
        // given
        customer.addRental(new Rental(regular, 1));
        customer.addRental(new Rental(newRelease, 1));
        customer.addRental(new Rental(children, 1));

        // when & then
        assertEquals(customer.statement(), "고객 고객님의 대여 기록\n" +
                "\t정규 영화\t2.0\n" +
                "\t신규 영화\t3.0\n" +
                "\t어린이 영화\t1.5\n" +
                "누적 대여료6.5\n" +
                "적립 포인트3");
    }
}