package app.entities.benders;

public class WaterBender extends Bender {

    private double waterClarity;

    public WaterBender(String name, int power, double waterClarity ) {
        super(name, power);
        this.waterClarity = waterClarity;
    }

    public double getWaterClarity() {
        return this.waterClarity;
    }

    @Override
    public double calculateTotalPower() {
        return super.getPower() * this.getWaterClarity();
    }

    @Override
    public String toString() {
        return String.format("###Water Bender: %s, Power: %d, Water Clarity: %.2f",
                super.getName(), super.getPower(), this.getWaterClarity());
    }
}
