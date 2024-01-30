package reduce.rating;

public class Review {

    private int points;
    private String reviews;

    public Review(int points, String reviews) {
        this.points = points;
        this.reviews = reviews;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }
}
