package kyunam.rental;

import kyunam.movie.MovieType;

import java.util.HashMap;
import java.util.Map;

public class RentalFeeCalculatorExecutor {
    private static final Map<MovieType, RentalFeeCalculator> rentalFeeCalculators = new HashMap();
    static {
        rentalFeeCalculators.put(MovieType.CHILDREN, new ChildrenTypeRentalFeeCalculator());
        rentalFeeCalculators.put(MovieType.NEW_RELEASE, new NewReleaseRentalFeeCalculator());
        rentalFeeCalculators.put(MovieType.REGULAR, new RegularTypeRentalFeeCalculator());
    }
    public static double execute(Rental rental, MovieType type) {
        return rentalFeeCalculators.get(type).calculate(rental);
    }
}
