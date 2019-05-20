package example;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class Customer {
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

    public String statement() {
        RentalsFeeCalculator rentalsFeeCalculator = new RentalsFeeCalculator(rentals);

        String result = getName() + "고객님의 대여 기록\n";

        //이번에 대여하는 비디오 정보와 대여료를 출력
        result += rentals.stream().map(rental -> rental.getRentalInfoString()).collect(Collectors.joining("\n"));
        //푸터행
        RentalsFee rentalsFee = rentalsFeeCalculator.calculate();
        result += "누적 대여료 : " + rentalsFee.getTotalAmount();
        result += "적립 포인트 : " + rentalsFee.getFrequentRenterPoints();
        return result;
    }

}
