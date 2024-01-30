package reduce;


import com.baeldung.streams.reduce.entities.Rating;

public class User {

    private String name;
    private int age;
    private final com.baeldung.streams.reduce.entities.Rating rating = new Rating();// TODO: revisar esta parte de raiting que es null por ende falla.

    public User (){}

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Rating getRating() {
        return rating;
    }

    /*public void setRating(Rating rating) {
        this.rating = rating;
    }*/
}
