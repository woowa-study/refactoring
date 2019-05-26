package example.point;

import example.MovieRentalCalculationRule;
import example.MovieRentalCondition;
import example.MoviePriceCode;

enum RentalPointByMovieType implements MovieRentalCalculationRule<MovieRentalCondition, Integer> {
    POINT_ON_REGULAR_MOVIE(MoviePriceCode.REGULAR),
    POINT_ON_NEW_RELEASE_MOVIE(MoviePriceCode.NEW_RELEASE) {
        @Override
        public Integer calculateOnCondition(MovieRentalCondition condition) {
            return condition.getDaysRented() > 1 ?
                    2 : super.calculateOnCondition(condition);
        }
    },
    POINT_ON_CHIDEREN_MOVIE(MoviePriceCode.CHILDREN);


    private MoviePriceCode movieType;

    RentalPointByMovieType(MoviePriceCode movieType) {
        this.movieType = movieType;
    }

    @Override
    public boolean evaluate(MovieRentalCondition condition) {
        return condition.isValid() && condition.getMovieType() == this.movieType;
    }

    @Override
    public Integer calculateOnCondition(MovieRentalCondition condition) {
        return 1;
    }
}
