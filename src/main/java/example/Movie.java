package example;

public class Movie {

    private String title;
    private Type type;

    private FeeCalculator feeCalculator;

    public Movie(String title, Type type) {
        this.title = title;
        this.type = type;

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

    public enum Type {
        CHILDREN,
        REGULAR,
        NEW_RELEASE;
    }
}
