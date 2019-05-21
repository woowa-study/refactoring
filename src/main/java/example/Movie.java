package example;

public class Movie {
    private final String title;
    private final MovieType moviceType;

    public Movie(String title, MovieType moviceType) {
        this.title = title;
        this.moviceType = moviceType;
    }

    public String getTitle() {
        return title;
    }

    public MovieType getMoviceType() {
        return moviceType;
    }

}
