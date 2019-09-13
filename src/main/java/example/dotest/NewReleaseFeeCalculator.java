package example.dotest;

public class NewReleaseFeeCalculator implements FeeCalculator {
    private static final double ADDITIONAL_FEE = 3;

    @Override
    public double calculate(int daysRented) {
        return daysRented * ADDITIONAL_FEE;
    }
}
