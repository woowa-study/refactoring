package example;

public class RegularFeeCalculator implements FeeCalculator {
    private static final double DEFAULT_FEE = 2.0;
    private static final int BASE_DAYS = 2;
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
