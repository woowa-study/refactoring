package example;

import org.junit.Before;
import org.junit.Test;

import static common.TestConstant.DEFAULT_DELTA;
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

    @Test
    public void totalFee_테스트() {
        // given
        customer.addRental(new Rental(regular, 1));
        customer.addRental(new Rental(newRelease, 1));
        customer.addRental(new Rental(children, 1));

        // when & then
        assertEquals(customer.getTotalFee(), 6.5, DEFAULT_DELTA);
    }

    @Test
    public void totalFrequentPoints_테스트() {
        // given
        customer.addRental(new Rental(regular, 1));
        customer.addRental(new Rental(newRelease, 1));
        customer.addRental(new Rental(children, 1));

        // when & then
        assertEquals(customer.getTotalFrequentPoints(), 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Customer_생성시_이름은_null을_허용하지_않습니다() {
        // given & when & then
        new Customer(null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void Customer_생성시_이름은_빈값을_허용하지_않습니다() {
        // given & when & then
        new Customer("");
    }
}