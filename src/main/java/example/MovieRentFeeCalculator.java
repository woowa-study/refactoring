package example;

import java.util.Arrays;

public class MovieRentFeeCalculator implements ChargeCalculatable<DefaultChargeCondition> {
    @Override
    public double chargeFee(DefaultChargeCondition condition) {
        MovieRentFeeCalculator.ChargeRuleByMovieTypeRentDays chargeRule = ChargeRuleByMovieTypeRentDays.build(condition.getMovieType());
        final int daysAfterThreshold = condition.getDaysRented() - chargeRule.getThreshold();
        if(daysAfterThreshold > 0){
            return (1 + daysAfterThreshold) * chargeRule.getDefaultFee();
        }
        return chargeRule.getDefaultFee();
    }
    // 음... threshold, defaultFee  정보를 movie 도메인이 갖게 하는게 나을까?
    private enum ChargeRuleByMovieTypeRentDays {
        REGULAR_MOVIE_CHARGE(MovieType.REGULAR, 2, 1.5),
        NEW_RELEASE_CHARGE(MovieType.NEW_RELEASE, 0, 3),
        CHILDREN_CHARGE(MovieType.CHILDREN, 3, 1.5);

        MovieType movieType;
        int threshold;
        double defaultFee;

        ChargeRuleByMovieTypeRentDays(MovieType movieType, int threshold, double defaultFee) {
            this.movieType = movieType;
            this.threshold = threshold;
            this.defaultFee = defaultFee;
        }

        public MovieType getMovieType() {
            return movieType;
        }

        public int getThreshold() {
            return threshold;
        }

        public double getDefaultFee() {
            return defaultFee;
        }

        public static ChargeRuleByMovieTypeRentDays build(MovieType movieType){
           return Arrays.stream(ChargeRuleByMovieTypeRentDays.values()).filter(x -> x.getMovieType() == movieType).findFirst()
                    .orElseThrow( () -> new RuntimeException("Not Supported"));
        }
    }

}
