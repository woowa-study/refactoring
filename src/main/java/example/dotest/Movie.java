package example.dotest;

import static java.util.Optional.ofNullable;

public class Movie {

    private String title;
    private Type type;

    private FeeCalculator feeCalculator;

    public Movie(String title, Type type) {
        this.title = ofNullable(title).orElseThrow(IllegalArgumentException::new);
        amendType(type);

        feeCalculator = FeeCalculatorFactory.getFeeCalculator(type);
    }

    public double getRentalFee(int daysRented) {
        return feeCalculator.calculate(daysRented);
    }

    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    //TODO FeeCalculator도 변경되게 해야함.
    public void amendType(Movie.Type type) {
        this.type = ofNullable(type).orElseThrow(IllegalArgumentException::new);
        this.feeCalculator = FeeCalculatorFactory.getFeeCalculator(type);
    }

    public enum Type {
        CHILDREN,
        REGULAR,
        NEW_RELEASE;
    }
}
