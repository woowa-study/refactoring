package example.dotest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RentalTest {
    private Movie regular = new Movie("정규 영화", Movie.Type.REGULAR);
    private Movie newRelease = new Movie("신규 영화", Movie.Type.NEW_RELEASE);
    private Movie children = new Movie("어린이 영화", Movie.Type.CHILDREN);

    @Test
    public void REGULAR_대여기간에_상관없이_1포인트가_적립된다() {
        Rental rental = new Rental(regular, 3);
        assertEquals(rental.getRenterPoint(), 1);
    }

    @Test
    public void CHILDREN_대여기간에_상관없이_1포인트가_적립된다() {
        Rental rental = new Rental(children, 3);
        assertEquals(rental.getRenterPoint(), 1);
    }

    @Test
    public void NEW_RELEASE_는_대여기간이_2일이상이면_1포인트가_추가적립된다() {
        Rental rental = new Rental(newRelease, 2);
        assertEquals(rental.getRenterPoint(), 2);
    }

    @Test
    public void NEW_RELEASE_는_대여기간이_1일이하이면_1포인트가_적립된다() {
        Rental rental = new Rental(newRelease, 1);
        assertEquals(rental.getRenterPoint(), 1);
    }

    @Test
    public void getMovieTitle_대여한_영화_제목을_가져온다() {
        Rental rental = new Rental(regular, 1);
        assertEquals(rental.getMovieTitle(), "정규 영화");
    }

    @Test(expected = IllegalArgumentException.class)
    public void Rental_생성시_Movie는_null일수_없습니다() {
        // given & when & then
        new Rental(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Rental_생성시_대여기간은_1일이상_이어야합니다() {
        // given & when & then
        new Rental(newRelease, 0);
    }
}