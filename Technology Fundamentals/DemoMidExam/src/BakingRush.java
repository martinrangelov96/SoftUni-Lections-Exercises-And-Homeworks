import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BakingRush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> actions = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        int energy = 100;
        int coins = 100;
        int i = 0;

        while (coins >= 0) {

            if (i == actions.size()) {
                break;
            }

            for (i = 0; i < actions.size(); i++) {
                String[] tokens = actions.get(i).split("-");
                String command = tokens[0];
                int value = Integer.parseInt(tokens[1]);

                if (command.equals("rest")) {
                    int initialEnergy = energy;
                    energy += value;
                    if (energy >= 100) {
                        energy = 100;
                        System.out.printf("You gained %d energy.%n", energy - initialEnergy);
                        System.out.printf("Current energy: %d.%n", 100);
                    } else {
                        System.out.printf("You gained %d energy.%n", value);
                        System.out.printf("Current energy: %d.%n", energy);
                    }
                } else if (command.equals("order")) {
                    if (energy >= 30) {
                        energy -= 30;
                        System.out.printf("You earned %d coins.%n", value);
                        coins += value;
                    } else {
                        energy += 50;
                        System.out.println("You had to rest!");
                    }
                } else {
                    coins -= value;
                    if (coins <= 0) {
                        System.out.printf("Closed! Cannot afford %s.", command);
                        return;
                    } else {
                        System.out.printf("You bought %s.%n", command);
                    }
                }
            }

        }

        System.out.println("Day completed!");
        System.out.printf("Coins: %d%n", coins);
        System.out.printf("Energy: %d%n", energy);

    }
}