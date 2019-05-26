package example;

public interface MovieRentalCalculationRule<T extends MovieRentalCondition, R> {
    boolean evaluate(T condition);
    R calculateOnCondition(T condition);
}
