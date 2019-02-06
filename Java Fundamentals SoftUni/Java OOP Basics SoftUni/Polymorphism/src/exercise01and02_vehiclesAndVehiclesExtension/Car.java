package exercise01and02_vehiclesAndVehiclesExtension;

import java.text.DecimalFormat;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumationInLitersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumationInLitersPerKm, tankCapacity);
    }

    @Override
    public void drive(double distance) {
        DecimalFormat df = new DecimalFormat("#.##");
        double fuel = super.getFuelQuantity();
        fuel -= distance * (super.getFuelConsumationInLitersPerKm() + 0.9);
        if (fuel >= 0) {
            System.out.printf("Car travelled %s km%n", df.format(distance));
            super.setFuelQuantity(fuel);
        } else {
            System.out.println("Car needs refueling");
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
