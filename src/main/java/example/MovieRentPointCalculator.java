package example;

import java.util.Map;
import java.util.function.Function;

public class MovieRentPointCalculator {
    private static Map<Movie.MoviceType, Function<Integer, Integer>> rentalPointCalcByMovieType;
    // 마음에 안듦.. enum에서 구현할까?
    static {
        rentalPointCalcByMovieType.putIfAbsent(Movie.MoviceType.REGULAR, (daysRented) -> 1);

        rentalPointCalcByMovieType.putIfAbsent(Movie.MoviceType.NEW_RELEASE, (daysRented) ->(daysRented > 1)? 2 : 1);

        rentalPointCalcByMovieType.putIfAbsent(Movie.MoviceType.CHILDREN, (daysRented) -> 1);
    }

    public static int calculatePoint(Movie.MoviceType moviceType, int daysRented){
        if(!rentalPointCalcByMovieType.containsKey(moviceType)){
            throw new RuntimeException("unsupported movie type to calculatePoint ");
        }
        return rentalPointCalcByMovieType.get(moviceType).apply(daysRented);
    }
}
