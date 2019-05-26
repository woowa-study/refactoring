package kyunam.customer;


import kyunam.common.TextGenerator;
import kyunam.rental.dto.RentalInfo;
import kyunam.rental.Rental;

import java.util.ArrayList;
import java.util.List;
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

    public List<RentalInfo> getRentalInfo() {
        return this.rentals.stream().map(rental -> new RentalInfo(rental.getMovie().getTitle(), rental.getRentalFee())).collect(Collectors.toList());
    }

    public double getTotalAmount() {
        return this.rentals.stream().mapToDouble(Rental::getRentalFee).reduce((a,b) -> a + b).getAsDouble();
    }

    public int getTotalFrequentRenterPoints() {
        return this.rentals.stream().mapToInt(Rental::getFrequentRenterPoint).reduce((a,b) -> a + b).getAsInt();
    }

    public String statement() {
        String result = getName() + "고객님의 대여 기록\n";
        result += TextGenerator.getRentalInfoListText(getRentalInfo());
        //푸터행
        result += "누적 대여료 : " + getTotalAmount();
        result += "적립 포인트 : " + getTotalFrequentRenterPoints();
        return result;
    }
}
