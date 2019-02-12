package lecture03_carShowExtended;

import java.io.Serializable;

public class Seat extends BaseCar implements Sellable, Serializable {
    private Double price;

    public Seat(String countryProduced, String model, Integer horsePower, String color, Double price) {
        super(countryProduced, model, color, horsePower);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
