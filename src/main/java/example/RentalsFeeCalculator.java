package example;

import example.rental.Rental;

import java.util.List;

public class RentalsFeeCalculator {

    public static RentalsFee calculate(List<Rental> rentals) {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        for ( Rental rental : rentals ) {
            totalAmount += rental.calculateRentalFee();
            //최신물을 이틀 이상 대여하면 보너스 포인트 지급
            frequentRenterPoints += rental.calculateBonusPoint();
        }
        return new RentalsFee(totalAmount, frequentRenterPoints);
    }
}
