package reduce;


import reduce.rating.Rating;

public class User {

    private String name;
    private int age;
    private final Rating rating = new Rating();// TODO: revisar esta parte de raiting que es null por ende falla.

    public User (){}

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(User user) {
        if(user != null) {
            this.name = user.getName();
            this.age = user.getAge();
        }
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

    public static boolean isRealUser(User user) {
        return user.getAge() > 0 && !user.getName().isEmpty();
    }

    public boolean isLegalName() {
        return this.name != null && this.name.length() > 3 && this.name.matches("^[A-Za-z\s]+$");
    }

}
