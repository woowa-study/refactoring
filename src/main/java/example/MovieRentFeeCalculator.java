package example;

import java.util.Map;
import java.util.function.Function;

public class MovieRentFeeCalculator {
    private static Map<Movie.MoviceType, Function<Integer, Double>> rentFeeCalcByyMovieType;
// 마음에 안듦.. enum에서 구현할까?
    static {
        rentFeeCalcByyMovieType.putIfAbsent(Movie.MoviceType.REGULAR, (daysRented) -> {
            double thisAmount = 2;
            if (daysRented > 2)
                thisAmount += (daysRented - 2) * 1.5;
            return thisAmount;
        });

        rentFeeCalcByyMovieType.putIfAbsent(Movie.MoviceType.NEW_RELEASE, (daysRented) -> Double.valueOf(daysRented * 3));

        rentFeeCalcByyMovieType.putIfAbsent(Movie.MoviceType.CHILDREN, (daysRented) -> {
            double  thisAmount = 1.5;
            if (daysRented > 3)
                thisAmount += (daysRented - 3) * 1.5;
            return thisAmount;
        });
    }

    public static double calculateRentFee(Movie.MoviceType moviceType, int daysRented){
        if(!rentFeeCalcByyMovieType.containsKey(moviceType)){
            throw new RuntimeException("unsupported movie type to calculateRentFee ");
        }
        return rentFeeCalcByyMovieType.get(moviceType).apply(daysRented);
    }
}
