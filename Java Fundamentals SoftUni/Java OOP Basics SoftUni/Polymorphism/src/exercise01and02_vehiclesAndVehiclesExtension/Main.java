package exercise01and02_vehiclesAndVehiclesExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carInfo = reader.readLine().split("\\s+");
        double carFuel = Double.parseDouble(carInfo[1]);
        double carFuelConsumptionPerLiter = Double.parseDouble(carInfo[2]);
        double carTankCapacity = Double.parseDouble(carInfo[3]);
        String[] truckInfo = reader.readLine().split("\\s+");
        double truckFuel = Double.parseDouble(truckInfo[1]);
        double truckFuelConsumptionPerLiter = Double.parseDouble(truckInfo[2]);
        double truckTankCapacity = Double.parseDouble(truckInfo[3]);
        String[] busInfo = reader.readLine().split("\\s+");
        double busFuel = Double.parseDouble(busInfo[1]);
        double busFuelConsumptionPerLiter = Double.parseDouble(busInfo[2]);
        double busTankCapacity = Double.parseDouble(busInfo[3]);


        Vehicle car = new Car(carFuel, carFuelConsumptionPerLiter, carTankCapacity);
        Vehicle truck = new Truck(truckFuel, truckFuelConsumptionPerLiter, truckTankCapacity);
        Vehicle bus = new Bus(busFuel, busFuelConsumptionPerLiter, busTankCapacity);

        int numberOfInputs = Integer.parseInt(reader.readLine());

        while (numberOfInputs-- > 0) {
            String[] commands = reader.readLine().split("\\s+");
            String vehicleCommand = commands[0];
            String vehicleName = commands[1];
            double vehicleCommandNumber = Double.parseDouble(commands[2]);

            switch (vehicleName) {
                case "Car":
                    if (vehicleCommand.equals("Drive")) {
                        car.drive(vehicleCommandNumber);
                    } else if (vehicleCommand.equals("Refuel")) {
                        if (vehicleCommandNumber <= 0) {
                            System.out.println("Fuel must be a positive number");
                            break;
                        }
                        car.refuelVehicle(vehicleCommandNumber);
                    }
                    break;
                case "Truck":
                    if (vehicleCommand.equals("Drive")) {
                        truck.drive(vehicleCommandNumber);
                    } else if (vehicleCommand.equals("Refuel")) {
                        if (vehicleCommandNumber <= 0) {
                            System.out.println("Fuel must be a positive number");
                            break;
                        }
                        truck.refuelVehicle(vehicleCommandNumber);
                    }
                    break;
                case "Bus":
                    if (vehicleCommand.equals("DriveEmpty")) {
                        bus.drive(vehicleCommandNumber);
                    } else if (vehicleCommand.equals("Drive")) {
                        bus.setBusBonusFuelWithPeople(1.4);
                        bus.drive(vehicleCommandNumber);
                    } else if (vehicleCommand.equals("Refuel")) {
                        if (vehicleCommandNumber <= 0) {
                            System.out.println("Fuel must be a positive number");
                            break;
                        }
                        bus.refuelVehicle(vehicleCommandNumber);
                    }
                    break;
                default:
                    break;
            }

        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);

    }
}
