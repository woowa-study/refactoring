package kyunam.rental;

public class RegularTypeRentalFeeCalculator implements RentalFeeCalculator {
    @Override
    public double calculate(Rental rental) {
        double thisAmount = 2;
        if (rental.getDaysRented() > 2)
            thisAmount += (rental.getDaysRented() - 2) * 1.5;
        return thisAmount;
    }
}
