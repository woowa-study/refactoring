package example;

import example.dto.CustomerView;
import example.dto.RentMovieView;
import example.formatter.RentalHistoryAsStringFormatter;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();
    private RentalHistoryAsStringFormatter rentalHistoryFormatter = new RentalHistoryAsStringFormatter();
    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        assert arg != null;
        this.rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement_2(){
        return rentalHistoryFormatter.format( new CustomerView(this.name),  new RentMovieView(this.rentals));
    }
//    public String statement() {
//        double totalAmount = 0;
//        int frequentRenterPoints = 0;
//        Iterator elements = rentals.iterator();
//        String result = getName() + "고객님의 대여 기록\n";
//        while (elements.hasNext()) {
//            double thisAmount = 0;
//            Rental each = (Rental) elements.next();
//
//            //비디오 종류별 대여료 계산
//            switch (each.getMovie().getPriceCode()) {
//
//                case Movie.REGULAR:
//                    thisAmount += 2;
//                    if (each.getDaysRented() > 2)
//                        thisAmount += (each.getDaysRented() - 2) * 1.5;
//                    break;
//                case Movie.NEW_RELEASE:
//                    thisAmount += each.getDaysRented() * 3;
//                    break;
//                case Movie.CHILDREN:
//                    thisAmount += 1.5;
//                    if (each.getDaysRented() > 3)
//                        thisAmount += (each.getDaysRented() - 3) * 1.5;
//                    break;
//            }
//
//
//            //적립포인트를 1포인트 증가.
//            frequentRenterPoints++;
//            //최신물을 이틀 이상 대여하면 보너스 포인트 지급
//            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
//                    && each.getDaysRented() > 1)
//                frequentRenterPoints++;
//
//            //이번에 대여하는 비디오 정보와 대여료를 출력
//            result += "\t" + each.getMovie().getTitle() + "\t"
//                    + String.valueOf(thisAmount) + "\n";
//            //현재까지 누적된 총 대여료
//            totalAmount += thisAmount;
//        }
//        //푸터행
//        result += "누적 대여료 : " + String.valueOf(totalAmount);
//        result += "적립 포인트 : " + String.valueOf(frequentRenterPoints);
//        return result;
//    }


}
