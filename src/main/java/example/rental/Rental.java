package example.rental;

import example.movie.Movie;
import example.movie.NewReleaseMovie;

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

    public double calculateRentalFee() {
        return movie.calculateRentalFee(this.daysRented);
    }

    public double calculateBonusPoint() {
        if (this.movie instanceof NewReleaseMovie && daysRented > 1) {
            return 2;
        }
        return 1;
    }
}
