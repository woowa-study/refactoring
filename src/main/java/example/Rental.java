package example;

import example.charge.movie.MovieChargeCondition;
import example.charge.movie.MovieRentFeeCalculator;
import example.point.MovieRentPointCalculator;

public class Rental {
    private Movie movie;
    private int daysRented;
    private MovieRentFeeCalculator movieRentFeeCalculator;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
        this.movieRentFeeCalculator = new MovieRentFeeCalculator();
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double calculateRentFee() {
        //비디오 종류별 대여료 계산
        return movieRentFeeCalculator.chargeFee(new MovieChargeCondition(movie.getMoviceType(), daysRented));
    }

    public int calculatePoint() {
        return MovieRentPointCalculator.calculatePoint(movie.getMoviceType(), daysRented);
    }
}
