package example;

import lombok.Getter;

@Getter
class RentalsFee {
    public RentalsFee(double totalAmount, int frequentRenterPoints) {
        this.totalAmount = totalAmount;
        this.frequentRenterPoints = frequentRenterPoints;
    }
    private double totalAmount;
    private int frequentRenterPoints;
}
