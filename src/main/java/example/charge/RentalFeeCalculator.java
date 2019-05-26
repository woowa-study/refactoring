package example.charge;

import example.MovieRentalCalculator;
import example.MovieRentalCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RentalFeeCalculator implements MovieRentalCalculator<MovieRentalCondition, RentalFee> {
//    private List<MovieRentalCalculationRule<MovieRentalCondition, Double>> chargeRules = new ArrayList<>();
    private List<RentalFeeChargeRuleByMovieTypeRentDays> chargeRules = new ArrayList<>();
    public RentalFeeCalculator() {
        chargeRules.addAll(Arrays.asList(RentalFeeChargeRuleByMovieTypeRentDays.values()));
    }

    @Override
    public RentalFee calculate(final MovieRentalCondition condition) {
        //apply exclusive charge rule
        RentalFeeChargeRuleByMovieTypeRentDays chargeRule = chargeRules.stream().filter(x -> x.evaluate(condition))
                .findFirst().orElseThrow(RentalChargeCalculateException.NoRuleAppliedException::new);
        return new RentalFee(chargeRule.calculateOnCondition(condition));
    }
}
