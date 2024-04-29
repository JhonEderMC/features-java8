package newinterface;

public class Car implements Vehicule {

    public Car() {
       System.out.println("Call static method interface: " + Vehicule.producer());
    }

}
