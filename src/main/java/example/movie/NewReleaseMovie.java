package example.movie;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double calculateRentalFee(int daysRented) {
        return daysRented * 3;
    }
}
