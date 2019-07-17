package app.entities.benders;

public abstract class Bender {

    private String name;
    private int power;

    public Bender(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return this.name;
    }

    public int getPower() {
        return this.power;
    }

    public abstract double calculateTotalPower();

    @Override
    public String toString() {
        return super.toString();
    }
}
