package example.dotest;

public class ChildrenFeeCalculator implements FeeCalculator {
    private static final double DEFAULT_FEE = 1.5;
    private static final int BASE_DAYS = 3;
    private static final double ADDITIONAL_FEE = 1.5;

    @Override
    public double calculate(int daysRented) {
        double rentalFee = DEFAULT_FEE;
        if (daysRented > BASE_DAYS) {
            rentalFee += (daysRented - BASE_DAYS) * ADDITIONAL_FEE;
        }
        return rentalFee;
    }
}
