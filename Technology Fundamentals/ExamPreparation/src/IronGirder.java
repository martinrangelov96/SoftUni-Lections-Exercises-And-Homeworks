import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IronGirder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> townsWithTimes = new HashMap<>();
        Map<String, Integer> townsWithPassengers = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Slide rule")) {

            if (input.contains("ambush")) {

                String[] data = input.split(":");
                String town = data[0];
                String[] secondData = data[1].split("->");
                int passengersCount = Integer.parseInt(secondData[1]);

                if (townsWithTimes.containsKey(town)) {
                    townsWithTimes.put(town, 0);
                    townsWithPassengers.put(town, townsWithPassengers.get(town) - passengersCount);
                }

            } else {

                String[] data = input.split(":");
                String town = data[0];
                String[] secondData = data[1].split("->");
                int time = Integer.parseInt(secondData[0]);
                int passengersCount = Integer.parseInt(secondData[1]);

                if (!townsWithTimes.containsKey(town)) {
                    townsWithTimes.put(town, time);
                    townsWithPassengers.put(town, passengersCount);
                } else {
                    if (townsWithTimes.get(town) > time || townsWithTimes.get(town) == 0) {
                        townsWithTimes.put(town, time);
                    }
                    townsWithPassengers.put(town, townsWithPassengers.get(town) + passengersCount);
                }

            }

            input = scanner.nextLine();
        }

        townsWithTimes.entrySet().stream()
                .sorted((a, b) -> {
                    if (a.getValue().compareTo(b.getValue()) == 0) {
                        return a.getKey().compareTo(b.getKey());
                    }
                    return a.getValue().compareTo(b.getValue());

                })
                .forEach(entry -> {
                    if (entry.getValue() != 0 && townsWithPassengers.get(entry.getKey()) > 0) {
                        System.out.printf("%s -> Time: %d -> Passengers: %d%n",
                                entry.getKey(),entry.getValue(),townsWithPassengers.get(entry.getKey()));
                    }

                });

    }
}
