package kyunam.rental;

import kyunam.movie.Movie;
import kyunam.movie.MovieType;

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

    public int getDaysRented() {
        return daysRented;
    }

    public double getRentalFee() {
        return RentalFeeCalculatorExecutor.execute(this, movie.getMovieType());
    }

    public int getFrequentRenterPoint() {
        //최신물을 이틀 이상 대여하면 보너스 포인트 지급
        if ((this.movie.getMovieType() == MovieType.NEW_RELEASE)
                && this.daysRented > 1)
            return 2;
        return 1;
    }
}
