package example.dotest;

import example.dotest.Movie;
import org.junit.Test;

public class MovieTest {

    @Test(expected = IllegalArgumentException.class)
    public void amendType_시_null이_들어가는_경우_예외처리() {
        // given
        Movie movie = new Movie("어벤져스", Movie.Type.REGULAR);

        // when & then
        movie.amendType(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void movie_생성시_type에_null이_들어가는_경우_에러처리() {
        // given & when & then
        Movie movie = new Movie("인태갓", null);

    }
}