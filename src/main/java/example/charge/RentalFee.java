package example.charge;

import example.CalculateResult;

public class RentalFee implements CalculateResult {
    private double rentalFee;

    public RentalFee(Double rentalFee) {
        assert rentalFee!= null && rentalFee >= 0;
        this.rentalFee = rentalFee;
    }

    public double getRentalFee(){
        return this.rentalFee;
    }
}
