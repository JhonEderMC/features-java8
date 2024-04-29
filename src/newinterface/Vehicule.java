package newinterface;

public interface Vehicule {
    /*
     The static producer() method is available only through and inside of an interface. it can't be overrriden by an
     implementing class.
     */
    static String producer() {
        return "N&F Vechicules";
    }

    default String getOverview() {
        return "ATV made by " + producer();
    }
}
