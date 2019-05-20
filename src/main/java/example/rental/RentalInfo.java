package example.rental;

import lombok.Getter;

@Getter
public class RentalInfo {
    private String title;
    private double rentalFee;

    public RentalInfo(String title, double rentalFee) {
        this.title = title;
        this.rentalFee = rentalFee;
    }

    public String getRentalInfoString() {
        return "\t" + this.title + "\t"
                + rentalFee + "\n";
    }
}
