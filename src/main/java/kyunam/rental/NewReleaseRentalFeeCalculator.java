package kyunam.rental;

public class NewReleaseRentalFeeCalculator  implements RentalFeeCalculator {
    @Override
    public double calculate(Rental rental) {
        return rental.getDaysRented() * 3;
    }
}
