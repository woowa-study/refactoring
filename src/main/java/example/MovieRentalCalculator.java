package example;

public interface MovieRentalCalculator<T extends MovieRentalCondition, R> {
    R calculate(T condition);
}
