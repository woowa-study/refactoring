package example.dto;

import example.Rental;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class RentMovieView {
    private final List<RentMovieDto> rentMovieDtoList;
    private final double totalRentFee;  //현재까지 누적된 총 대여료
    private final int accumulatedPoints;  //이번에 대여하는 비디오 정보와 대여료를 출력

    public RentMovieView(List<Rental> rentals) {
        this.rentMovieDtoList = rentals.stream().map(RentMovieDto::new)
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
        this.totalRentFee = rentMovieDtoList.stream().mapToDouble(RentMovieDto::getRentFee).sum();
        this.accumulatedPoints = rentMovieDtoList.stream().mapToInt(RentMovieDto::getPoint).sum();
    }

    public List<RentMovieDto> getRentMovieDtoList() {
        return new ArrayList<>(rentMovieDtoList);
    }

    public double getTotalRentFee() {
        return totalRentFee;
    }

    public int getAccumulatedPoints() {
        return accumulatedPoints;
    }
    public static class RentMovieDto {
        private String movieName;
        private double rentFee;
        private int point;

        public RentMovieDto(Rental rental){
            this.movieName = rental.getMovie().getTitle(); // - getter 없이는 rental이 dto를 알아야(의존성) 하므로 X
            this.rentFee = rental.calculateRentFee();
            this.point = rental.calculatePoint();
        }

        public String getMovieName() {
            return movieName;
        }

        public double getRentFee() {
            return rentFee;
        }

        public int getPoint() {
            return point;
        }
    }
}
