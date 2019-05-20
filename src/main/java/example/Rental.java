package example;

import static example.Movie.Type.NEW_RELEASE;
import static java.util.Optional.ofNullable;

public class Rental {
    private final static int DEFAULT_RENTAL_POINT = 1;
    private final static int NEW_RELEASE_ADDITIONAL_POINT_RENT_DAY = 1;

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        if (daysRented <= 0) {
            throw new IllegalArgumentException();
        }

        this.movie = ofNullable(movie).orElseThrow(IllegalArgumentException::new);
        this.daysRented = daysRented;
    }

    public double getRentalFee() {
        // 비디오 종류별 대여료 계산
        return movie.getRentalFee(daysRented);
    }


    public int getRenterPoint() {
        // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
        if ((movie.getType() == NEW_RELEASE)
                && daysRented > NEW_RELEASE_ADDITIONAL_POINT_RENT_DAY) {
            return DEFAULT_RENTAL_POINT + 1;
        }

        return DEFAULT_RENTAL_POINT;
    }

    public String getMovieTitle() {
        return movie.getTitle();
    }
}
