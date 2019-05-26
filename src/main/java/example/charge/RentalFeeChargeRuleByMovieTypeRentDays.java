package example.charge;

import example.MovieRentalCalculationRule;
import example.MovieRentalCondition;
import example.MoviePriceCode;

// threshold, defaultFee 를 갖는 enum이 아닌 클래스로 따로 만들까?
// enum으로 하니깐 calculateOnCondition 요걸 테스트하기가 어렵구나
enum RentalFeeChargeRuleByMovieTypeRentDays implements MovieRentalCalculationRule<MovieRentalCondition, Double> {
    CHILDREN_CHARGE(MoviePriceCode.CHILDREN, 3, 1.5),
    NEW_RELEASE_CHARGE(MoviePriceCode.NEW_RELEASE, 1, 3),
    REGULAR_MOVIE_CHARGE(MoviePriceCode.REGULAR, 2, 1.5);

    MoviePriceCode movieType;
    int threshold;
    double defaultFee;

    RentalFeeChargeRuleByMovieTypeRentDays(MoviePriceCode movieType, int threshold, double defaultFee) {
        this.movieType = movieType;
        this.threshold = threshold;
        this.defaultFee = defaultFee;
    }

    public MoviePriceCode getMovieType() {
        return movieType;
    }

    public int getThreshold() {
        return threshold;
    }

    public double getDefaultFee() {
        return defaultFee;
    }

    @Override
    public boolean evaluate(MovieRentalCondition chargeCondition) {
        return chargeCondition.isValid() && chargeCondition.getMovieType() == this.movieType;
    }

    // 이게 여기 있는게 맞는지, rule이 적용될때의 "action"
    @Override
    public Double calculateOnCondition(MovieRentalCondition condition) {
        return calculate(condition.getDaysRented(), this.getDefaultFee(), this.getThreshold());
    }
    static double calculate(int daysRented, double defaultFee, int threshold) {
        final int daysAfterThreshold = daysRented - threshold;
        double result = defaultFee;
        if (daysAfterThreshold > 0) {
            result += (daysAfterThreshold) * defaultFee;
        }
        return result;
    }
}
