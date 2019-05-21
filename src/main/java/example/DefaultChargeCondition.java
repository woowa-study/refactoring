package example;

class DefaultChargeCondition implements ChargeCondition {
    private final MovieType movieType;
    private final int daysRented;

    public DefaultChargeCondition(MovieType movieType, int daysRented) {
        this.movieType = movieType;
        this.daysRented = daysRented;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public int getDaysRented() {
        return daysRented;
    }

    @Override
    public boolean isValid() {
        return movieType != null && daysRented > 0;
    }
}
