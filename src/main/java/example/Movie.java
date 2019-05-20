package example;

public class Movie {
    private final String title;
    private final MoviceType moviceType;

    public Movie(String title, MoviceType moviceType) {
        this.title = title;
        this.moviceType = moviceType;
    }

    public String getTitle() {
        return title;
    }

    public MoviceType getMoviceType() {
        return moviceType;
    }

    enum MoviceType {
        CHILDREN, REGULAR, NEW_RELEASE;
    }
}
