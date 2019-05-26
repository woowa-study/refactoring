package kyunam.rental;

public class ChildrenTypeRentalFeeCalculator implements RentalFeeCalculator {
    @Override
    public double calculate(Rental rental) {
        double thisAmount = 1.5;
        if (rental.getDaysRented() > 3)
            thisAmount += (rental.getDaysRented() - 3) * 1.5;
        return thisAmount;
    }
}
