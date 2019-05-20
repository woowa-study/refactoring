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

    public String getRentalInfoString() {
        return "\t" + this.movie.getTitle() + "\t"
                + this.movie.calculateRentalFee(daysRented)  + "\n";
    }

    public double calculateRentalFee() {
        return movie.calculateRentalFee(this.daysRented);
    }
}
