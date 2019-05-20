package example.dotest;

import java.util.Objects;
import java.util.Vector;

public class Customer {

    private String name;
    private Vector<Rental> rentals = new Vector<>();

    public Customer(String name) {
        if (Objects.isNull(name) || "".equals(name)) {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        StringBuilder statement = new StringBuilder();
        statement.append(String.format("%s 고객님의 대여 기록\n", name));

        rentals.forEach(rental ->
                statement.append(String.format("\t%s\t%.1f\n", rental.getMovieTitle(), rental.getRentalFee()))
        );

        statement.append(String.format("누적 대여료%.1f\n", getTotalFee()));
        statement.append(String.format("적립 포인트%d", getTotalFrequentPoints()));

        return statement.toString();
    }


    public double getTotalFee() {
        return rentals.stream()
                .mapToDouble(Rental::getRentalFee)
                .sum();
    }

    public int getTotalFrequentPoints() {
        return rentals.stream()
                .mapToInt(Rental::getRenterPoint)
                .sum();
    }
}
