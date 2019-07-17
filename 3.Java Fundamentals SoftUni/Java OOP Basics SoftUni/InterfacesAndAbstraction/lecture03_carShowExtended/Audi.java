package lecture03_carShowExtended;

public class Audi extends BaseCar implements Rentable {
    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String countryProduced, String model, String color,
                Integer horsePower, Integer minRentDay, Double pricePerDay) {
        super(countryProduced, model, color, horsePower);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

}
