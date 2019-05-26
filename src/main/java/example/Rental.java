package example;

import example.charge.RentalFeeCalculator;
import example.point.PointCalculator;

public class Rental {
    private final Movie movie;
    private final int daysRented;
    private final RentalFeeCalculator movieRentFeeCalculator = new RentalFeeCalculator();
    private final PointCalculator pointCalculator = new PointCalculator();
    private final MovieRentalCondition movieRentalCondition;
    public Rental(Movie movie, int daysRented) {
        assert movie != null && daysRented > 0;
        this.movie = movie;
        this.daysRented = daysRented;
        this.movieRentalCondition = new MovieRentalCondition(movie.getMovieType(), daysRented);
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double calculateRentFee() {
        //비디오 종류별 대여료 계산
        return movieRentFeeCalculator.calculate(movieRentalCondition)
                .getRentalFee();
    }

    public int calculatePoint() {
        return pointCalculator.calculate(movieRentalCondition)
                .getPoint();
    }
}
