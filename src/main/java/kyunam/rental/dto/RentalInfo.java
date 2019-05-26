package kyunam.rental.dto;

public class RentalInfo {
    String title;
    Double rentalFee;

    public RentalInfo(String title, Double rentalFee) {
        this.title = title;
        this.rentalFee = rentalFee;
    }

    public String getTitle() {
        return title;
    }

    public Double getRentalFee() {
        return rentalFee;
    }
}
