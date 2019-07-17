package app.entities;

import app.entities.cars.Car;

import java.util.ArrayList;
import java.util.Collection;

public class Garage {

    private Collection<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public boolean hasCar(Car car) {
        return this.parkedCars.contains(car);
    }

    public void addInGarage(Car car) {
        this.parkedCars.add(car);
    }

    public void removeFromGarage(Car car) {
//        if (parkedCars.contains(car)) {
            this.parkedCars.remove(car);
//        }
    }

    public void tuneCars(int tuneIndex, String addOn) {
        this.parkedCars.forEach(car -> {
            car.increaseHorsepower(tuneIndex);
            car.increaseSuspension(tuneIndex / 2);

            String carType = car.getClass().getSimpleName();

            switch (carType) {
                case "ShowCar":
                    car.tune(tuneIndex);
                    break;
                case "PerformanceCar":
                    car.tune(addOn);
                    break;
            }
        });

    }
}
