package example;

import example.rental.Rental;
import example.rental.RentalInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Customer {
    public static final String DELIMITER = "\n";
    private RentalsFeeCalculator rentalsFeeCalculator = new RentalsFeeCalculator();
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        this.rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public List<RentalInfo> getRentalInfo() {
        return rentals.stream()
                .map(rental -> new RentalInfo(rental.getMovie().getTitle(), rental.calculateRentalFee())).collect(Collectors.toList());
    }

    public RentalsFee getTotalRentalFee() {
        return rentalsFeeCalculator.calculate(this.rentals);
    }

    public String statement() {

        String result = getName() + "고객님의 대여 기록\n";

        //이번에 대여하는 비디오 정보와 대여료를 출력
        result += getRentalInfo().stream().map(RentalInfo::getRentalInfoString).collect(Collectors.joining(DELIMITER));
        //푸터행
        RentalsFee rentalsFee = getTotalRentalFee();
        result += "누적 대여료 : " + rentalsFee.getTotalAmount();
        result += "적립 포인트 : " + rentalsFee.getFrequentRenterPoints();
        return result;
    }

}
