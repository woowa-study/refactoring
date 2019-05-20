package example;

import java.util.List;

public class RentalsFeeCalculator {
    private List<Rental> rentals;

    public RentalsFeeCalculator(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public RentalsFee calculate() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        for ( Rental rental : rentals ) {
            totalAmount += rental.calculateRentalFee();
            //적립포인트를 1포인트 증가.
            frequentRenterPoints++;
            //최신물을 이틀 이상 대여하면 보너스 포인트 지급
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                    && rental.getDaysRented() > 1)
                frequentRenterPoints++;
        }
        return new RentalsFee(totalAmount, frequentRenterPoints);
    }
}
