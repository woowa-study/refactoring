package example;


public class MovieRentalCondition {
    private final MoviePriceCode movieType;
    private final int daysRented;

    public MovieRentalCondition(MoviePriceCode movieType, int daysRented) {
        this.movieType = movieType;
        this.daysRented = daysRented;
    }

    public MoviePriceCode getMovieType() {
        return movieType;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public boolean isValid() {
        return movieType != null && daysRented > 0;
    }
}
