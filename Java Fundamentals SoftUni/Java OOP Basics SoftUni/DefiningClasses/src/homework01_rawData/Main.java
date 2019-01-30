package homework01_rawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfCars = Integer.parseInt(reader.readLine());

        List<Car> cars = new ArrayList<>();
        List<Tire> tires = null;

        for (int i = 0; i < numberOfCars; i++) {
            String[] tokens = reader.readLine().split("\\s+");

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
            tires = new ArrayList<>();
            tires.add(new Tire(tire1Pressure, tire1Age));
            tires.add(new Tire(tire2Pressure, tire2Age));
            tires.add(new Tire(tire3Pressure, tire3Age));
            tires.add(new Tire(tire4Pressure, tire4Age));

            Car car = new Car(model, engine, cargo, tires);

            cars.add(car);

        }

        String fragileOrFlamable = reader.readLine();

        if ("fragile".equals(fragileOrFlamable)) {
            for (int i = 0; i < cars.size(); i++) {
                if (cars.get(i).getCargo().getCargoType().equals("fragile")) {
                    for (int j = 0; j < 4; j++) {
                        if (cars.get(i).getTires().get(j).getTirePressure() < 1) {
                            System.out.println(cars.get(i).getModel());
                            break;
                        }
                    }
                }
            }
        } else if ("flamable".equals(fragileOrFlamable)) {
            for (int i = 0; i < cars.size(); i++) {
                if (cars.get(i).getCargo().getCargoType().equals("flamable")) {
                    for (int j = 0; j < 4; j++) {
                        if (cars.get(i).getEngine().getEnginePower() > 250) {
                            System.out.println(cars.get(i).getModel());
                            break;
                        }
                    }
                }
            }
        }
    }
}
