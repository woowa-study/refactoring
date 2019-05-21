package example;

import java.util.Map;
import java.util.function.Function;

public class MovieRentPointCalculator {
    private static Map<MovieType, Function<Integer, Integer>> rentalPointCalcByMovieType;
    // 마음에 안듦.. enum에서 구현할까?
    static {
        rentalPointCalcByMovieType.putIfAbsent(MovieType.REGULAR, (daysRented) -> 1);

        rentalPointCalcByMovieType.putIfAbsent(MovieType.NEW_RELEASE, (daysRented) ->(daysRented > 1)? 2 : 1);

        rentalPointCalcByMovieType.putIfAbsent(MovieType.CHILDREN, (daysRented) -> 1);
    }

    public static int calculatePoint(MovieType moviceType, int daysRented){
        if(!rentalPointCalcByMovieType.containsKey(moviceType)){
            throw new RuntimeException("unsupported movie type to calculatePoint ");
        }
        return rentalPointCalcByMovieType.get(moviceType).apply(daysRented);
    }
}
