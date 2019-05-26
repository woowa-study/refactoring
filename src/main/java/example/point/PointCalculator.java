package example.point;

import example.MovieRentalCalculator;
import example.MovieRentalCondition;
import example.charge.RentalChargeCalculateException;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class PointCalculator implements MovieRentalCalculator<MovieRentalCondition, Point> {
    private List<RentalPointByMovieType> rentalPointRuls = new ArrayList<>();

    public PointCalculator() {
        this.rentalPointRuls.addAll(Arrays.asList(RentalPointByMovieType.values()));
    }

    @Override
    public Point calculate(MovieRentalCondition condition) {
        RentalPointByMovieType rentalPointRule = rentalPointRuls.stream().filter(x -> x.evaluate(condition))
                .findFirst().orElseThrow(RentalChargeCalculateException.NoRuleAppliedException::new);
        return new Point(rentalPointRule.calculateOnCondition(condition));
    }
}

