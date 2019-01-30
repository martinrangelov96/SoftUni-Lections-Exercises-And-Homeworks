package exercise03_car_salesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfEngines = Integer.parseInt(reader.readLine());

        Map<String, Engine> engines = new LinkedHashMap<>();

        while (countOfEngines-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String engineModel = tokens[0];
            int enginePower = Integer.parseInt(tokens[1]);

            Engine engine = null;

            switch (tokens.length) {
                case 2:
                    engine = new Engine(engineModel, enginePower);
                    break;
                case 3:
                    if (tokens[2].matches("\\d+")) {
                        int engineDisplacement = Integer.parseInt(tokens[2]);
                        engine = new Engine(engineModel, enginePower, engineDisplacement);
                    } else {
                        String engineEfficiency = tokens[2];
                        engine = new Engine(engineModel, enginePower, engineEfficiency);
                    }
                    break;
                case 4:
                    int engineDisplacement = Integer.parseInt(tokens[2]);
                    String engineEfficiency = tokens[3];
                    engine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
                    break;
            }

            engines.putIfAbsent(engineModel, engine);
        }

        int countOfCars = Integer.parseInt(reader.readLine());

        List<Car> cars = new ArrayList<>();

        while (countOfCars-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String carModel = tokens[0];
            String carEngine = tokens[1];

            Car car = null;

            switch (tokens.length) {
                case 2:
                    car = new Car(carModel, engines.get(carEngine));
                    break;
                case 3:
                    if (tokens[2].matches("\\d+")) {
                        int carWeight = Integer.parseInt(tokens[2]);
                        car = new Car(carModel, engines.get(carEngine), carWeight);
                    } else {
                        String carColor = tokens[2];
                        car = new Car(carModel, engines.get(carEngine), carColor);
                    }
                    break;
                case 4:
                    int carWeight = Integer.parseInt(tokens[2]);
                    String carColor = tokens[3];
                    car = new Car(carModel, engines.get(carEngine), carWeight, carColor);
                    break;
            }

            cars.add(car);
        }

        cars.forEach(System.out::println);

    }
}
