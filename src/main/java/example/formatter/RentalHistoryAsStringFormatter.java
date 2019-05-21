package example.formatter;

import example.dto.CustomerView;
import example.dto.RentMovieView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RentalHistoryAsStringFormatter implements RentalHistoryFormatter<String> {
    private static final String ACCUMULATED_POINT_FORMAT = "누적 대여료 : %s적립 포인트 : %s";
    private static final String CUSTOMER_FORMAT = "%s 고객님의 대여 기록\n";
    private static final String RENTAL_MOVIE_FORMAT = "\t%s\t%s\n";

    public String format(CustomerView customerView, RentMovieView rentMovieView) { // customerView, rentMovieView는 자주 따로 쓰이지 않을까 싶어서 Dto 분리
        StringBuilder sb = new StringBuilder();
        sb.append(formatCustomerView(customerView));
        sb.append(formatRentMovieDtoList(rentMovieView.getRentMovieDtoList(), this::formatRentMovieDto));
        sb.append(formatRentMovieView(rentMovieView));
        return sb.toString();
    }
    //갠적으로 아랫부분 맘에 안드는데, 어떻게 바꿔야할지 모르겠음..
    private String formatCustomerView(CustomerView customerView){
       return String.format(CUSTOMER_FORMAT, customerView.getName());
    }
    private String formatRentMovieView(RentMovieView rentMovieView){
        return String.format(ACCUMULATED_POINT_FORMAT, rentMovieView.getTotalRentFee(), rentMovieView.getAccumulatedPoints());
    }
    private String formatRentMovieDtoList(List<RentMovieView.RentMovieDto> rentMovieDtos, Function<RentMovieView.RentMovieDto, String> formatFunc) {
        return rentMovieDtos.stream().map(formatFunc).collect(Collectors.joining());
    }
    private String formatRentMovieDto(RentMovieView.RentMovieDto rentMovieDto) {
        return String.format(RENTAL_MOVIE_FORMAT, rentMovieDto.getMovieName(), rentMovieDto.getRentFee());
    }
}
