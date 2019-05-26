package example;

public class Movie {
    private final String title;
    private final MoviePriceCode moviceType;

    public Movie(String title, MoviePriceCode movieType) {
        assert title != null && movieType != null;
        this.title = title;
        this.moviceType = movieType;
    }

    public String getTitle() {
        return title;
    }

    public MoviePriceCode getMovieType() {
        return moviceType;
    }
}
