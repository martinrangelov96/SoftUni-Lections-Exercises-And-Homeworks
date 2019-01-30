package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<Car>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire = new Tire(
                    tire1Pressure, tire1Age, tire2Pressure, tire2Age
                    , tire3Pressure, tire3Age, tire4Pressure, tire4Age);

            Car car = new Car(model, engine, cargo, tire);

            cars.add(car);

        }

        String cargoTypeInput = scanner.nextLine();

        for (Car car : cars) {
            if (cargoTypeInput.equals("fragile")) {
                if (car.getCargo().getCargoType().equals("fragile") &&
                        (car.getTire().getTire1Pressure() < 1
                                || car.getTire().getTire2Pressure() < 1
                                || car.getTire().getTire3Pressure() < 1
                                || car.getTire().getTire4Pressure() < 1)) {
                    System.out.println(car.getModel());
                }

            } else {

                if (car.getEngine().getEnginePower() > 250) {
                    System.out.println(car.getModel());
                }

            }
        }
    }
}
