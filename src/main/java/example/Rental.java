package example;

import static example.Movie.Type.NEW_RELEASE;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getRentalFee() {
        // 비디오 종류별 대여료 계산
        return movie.getRentalFee(daysRented);
    }


    public int getRenterPoint() {
        int rentalPoint = 1;
        // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
        if ((movie.getType() == NEW_RELEASE)
                && daysRented > 1) {
            rentalPoint++;
        }

        return rentalPoint;
    }
}
