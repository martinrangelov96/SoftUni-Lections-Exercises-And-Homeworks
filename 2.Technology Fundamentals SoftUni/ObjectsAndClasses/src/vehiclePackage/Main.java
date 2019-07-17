package vehiclePackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Vehicle> cars = new ArrayList<>();
        ArrayList<Vehicle> trucks = new ArrayList<>();

        String line = scanner.nextLine();

        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");

            Vehicle vehicle = new Vehicle(tokens[0],tokens[1],tokens[2],Integer.parseInt(tokens[3]));

            if (vehicle.getType().equals("Truck")) {
                trucks.add(vehicle);
            } else {
                cars.add(vehicle);
            }

            line = scanner.nextLine();
        }

        line = scanner.nextLine();

        while(!line.equals("Close the Catalogue")) {

            String model = line;

            for (Vehicle truck : trucks) {
                if (truck.getModel().equals(model)) {
                    System.out.println(truck.toString());
                }
            }

            for (Vehicle car : cars) {
                if (car.getModel().equals(model)) {
                    System.out.println(car.toString());
                }
            }

            line = scanner.nextLine();
        }

        double truckHpAvg = 0;
        double carHpAvg = 0;
        double carHpSum = 0;
        double truckHpSum = 0;

        if (!cars.isEmpty()) {
            for (Vehicle car : cars) {
                carHpSum += car.getHorsepower();
            }

            carHpAvg = carHpSum / cars.size();
        }

        System.out.printf("Cars have average horsepower of: %.2f.%n",carHpAvg);

        if (!trucks.isEmpty()) {
            for (Vehicle truck : trucks) {
                truckHpSum += truck.getHorsepower();
            }

            truckHpAvg = truckHpSum / trucks.size();
        }

        System.out.printf("Trucks have average horsepower of: %.2f.%n",truckHpAvg);

    }
}
