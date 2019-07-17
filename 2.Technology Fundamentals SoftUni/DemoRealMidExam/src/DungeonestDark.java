import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DungeonestDark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int coins = 0;

        List<String> commands = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        int bestRoomCounter = 0;

        for (int i = 0; i < commands.size(); i++) {
            bestRoomCounter++;

            String[] tokens = commands.get(i).split(" ");
            String firstInput = tokens[0];
            int healingPoints = Integer.parseInt(tokens[1]);

            if (firstInput.equals("potion")) {
                int initialHealth = health;
                health += healingPoints;

                if (health >= 100) {
                    health = 100;
                    healingPoints = health - initialHealth;
                    System.out.printf("You healed for %d hp.%n", healingPoints);
                    System.out.printf("Current health: %d hp.%n", health);
                } else {
                    System.out.printf("You healed for %d hp.%n", healingPoints);
                    System.out.printf("Current health: %d hp.%n", health);
                }
            } else if (firstInput.equals("chest")) {

                int foundCoins = Integer.parseInt(tokens[1]);
                coins += foundCoins;
                System.out.printf("You found %d coins.%n", foundCoins);

            } else {
                String monsterName = tokens[0];
                int monsterAttack = Integer.parseInt(tokens[1]);

                health -= monsterAttack;

                if (health > 0) {
                    System.out.printf("You slayed %s.%n", monsterName);
                } else {
                    System.out.printf("You died! Killed by %s.%n", monsterName);
                    System.out.printf("Best room: %d%n", bestRoomCounter);
                    return;
                }
            }

        }

        System.out.printf("You've made it!%n");
        System.out.printf("Coins: %d%n",coins);
        System.out.printf("Health: %d%n",health);

    }

}
