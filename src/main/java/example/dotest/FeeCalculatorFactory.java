package example.dotest;

public class FeeCalculatorFactory {

    public static FeeCalculator getFeeCalculator(Movie.Type type) {
        switch (type) {
            case REGULAR:
                return new RegularFeeCalculator();
            case CHILDREN:
                return new ChildrenFeeCalculator();
            case NEW_RELEASE:
                return new NewReleaseFeeCalculator();
            default:
                throw new IllegalStateException();
        }
    }
}
