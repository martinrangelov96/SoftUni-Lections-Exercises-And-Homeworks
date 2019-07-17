package exercise01and02_vehiclesAndVehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends Vehicle {

    protected Bus(double fuelQuantity, double fuelConsumationInLitersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumationInLitersPerKm, tankCapacity);
    }

    @Override
    public void setBusBonusFuelWithPeople(double busBonusFuelWithPeople) {
        super.setBusBonusFuelWithPeople(1.4);
    }

    @Override
    public void drive(double distance) {
        DecimalFormat df = new DecimalFormat("#.##");
        double fuel = super.getFuelQuantity();
        fuel -= distance * (super.getFuelConsumationInLitersPerKm() + this.getBusBonusFuelWithPeople());
        if (fuel >= 0) {
            System.out.printf("Bus travelled %s km%n", df.format(distance));
            super.setFuelQuantity(fuel);
        } else {
            System.out.println("Bus needs refueling");
        }
    }

    @Override
    public void refuelVehicle(double liters) {
        if (liters <= super.getTankCapacity()) {
            double refueledValue;
            refueledValue = super.getFuelQuantity() + liters;
            super.setFuelQuantity(refueledValue);
        } else {
            System.out.println("Cannot fit fuel in tank");
        }
    }
}
