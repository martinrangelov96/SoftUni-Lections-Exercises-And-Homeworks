package lection01_constructors.test;

public class Car {

    private String model;
    private Long maxMph;
    private double price;

    public Car() {
    }

    public Car(String model, double price) {
        this(model, 0L, price);
    }

    public Car(String model, Long maxMph, double price) {
        this.model = model;
        this.maxMph = maxMph;
        this.price = price;
    }
}
