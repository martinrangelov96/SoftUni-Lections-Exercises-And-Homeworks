package exercise01and02_vehiclesAndVehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumationInLitersPerKm;
    private double tankCapacity;
    private double busBonusFuelWithPeople;

    protected Vehicle(double fuelQuantity, double fuelConsumationInLitersPerKm, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.fuelConsumationInLitersPerKm = fuelConsumationInLitersPerKm;
        this.setTankCapacity(tankCapacity);
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity > 0) {
            this.fuelQuantity = fuelQuantity;
        } else {
            System.out.println("Fuel must be a positive number");
        }
    }

    protected double getFuelQuantity() {
        return this.fuelQuantity;
    }


    protected double getFuelConsumationInLitersPerKm() {
        return this.fuelConsumationInLitersPerKm;
    }


    public abstract void drive(double distance);
    public abstract void refuelVehicle(double liters);

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        return String.format("%s: %s",this.getClass().getSimpleName(), df.format(this.getFuelQuantity()));
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    protected double getTankCapacity() {
        return this.tankCapacity;
    }

    public void setBusBonusFuelWithPeople(double busBonusFuelWithPeople) {
        this.busBonusFuelWithPeople = busBonusFuelWithPeople;
    }

    public double getBusBonusFuelWithPeople() {
        return this.busBonusFuelWithPeople;
    }
}
