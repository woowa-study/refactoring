package example;

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

    public double calculateRentFee() {
        //비디오 종류별 대여료 계산
        return MovieRentFeeCalculator.calculateRentFee(movie.getMoviceType(), daysRented);
    }

    public int calculatePoint() {
        return MovieRentPointCalculator.calculatePoint(movie.getMoviceType(), daysRented);
    }
}
