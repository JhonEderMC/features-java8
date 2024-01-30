package reduce.rating;

import java.util.ArrayList;
import java.util.List;

public class Rating {

    private double points;
    private List<Review> reviews = new ArrayList<Review>();

    public void add(Review review) {
        this.reviews.add(review);
        this.points = this.comPuteRating();
    }

    private double comPuteRating() {
        double totalPoints = this.reviews.stream().map((Review::getPoints)).reduce(0, Integer::sum);
        this.points = totalPoints / this.reviews.size();
        return this.points;
    }

    public static Rating average(Rating rating1, Rating rating2) {
        Rating ratingCombined = new Rating();
        ratingCombined.reviews = new ArrayList<Review>(rating1.reviews);
        rating2.reviews.forEach(ratingCombined::add);
        return  ratingCombined;
    }

    public double getPoints() {
        return points;
    }
}
