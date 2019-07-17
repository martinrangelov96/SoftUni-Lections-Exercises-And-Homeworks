package exercise01and02_vehiclesAndVehiclesExtension;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumationInLitersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumationInLitersPerKm, tankCapacity);
    }

    @Override
    public void drive(double distance) {
        DecimalFormat df = new DecimalFormat("#.##");
        double fuel = super.getFuelQuantity();
        fuel -= distance * (super.getFuelConsumationInLitersPerKm() + 1.6);
        if (fuel >= 0) {
            System.out.printf("Truck travelled %s km%n", df.format(distance));
            super.setFuelQuantity(fuel);
        } else {
            System.out.println("Truck needs refueling");
        }
    }

    @Override
    public void refuelVehicle(double liters) {
        if (liters <= super.getTankCapacity()) {
            double refueledValue;
            refueledValue = super.getFuelQuantity() + (liters * 0.95);
            super.setFuelQuantity(refueledValue);
        } else {
            System.out.println("Cannot fit fuel in tank");
        }

    }
}
