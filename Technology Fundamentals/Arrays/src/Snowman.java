import java.util.Arrays;
import java.util.Scanner;

public class Snowman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] snowmen = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        while (snowmen.length > 1) {
            int alive = snowmen.length;
            for (int i = 0; i < snowmen.length && alive > 1; i++) {
                int attackerIndex = i;
                int attackerValue = snowmen[attackerIndex];
                if (attackerValue == -1) {
                    continue;
                }

                int targetIndex = attackerValue % snowmen.length;
                if (targetIndex == attackerIndex) {
                    System.out.printf("%d performed harakiri%n", attackerIndex);
                    snowmen[targetIndex] = -1;
                    alive--;
                    continue;
                }

                int difference = Math.abs(attackerIndex - targetIndex);
                System.out.printf("%d x %d -> ", attackerIndex, targetIndex);
                if (difference % 2 == 0) {
                    System.out.printf("%d wins%n", attackerIndex);
                    if (snowmen[targetIndex] == -1) {
                        continue;
                    }
                    snowmen[targetIndex] = -1;
                    alive--;
                } else {
                    System.out.printf("%d wins%n", targetIndex);
                    if (snowmen[attackerIndex] == -1) {
                        continue;
                    }
                    snowmen[attackerIndex] = -1;
                    alive--;
                }

            }

            if (alive <= 1) {
                break;
            }
            int[] aliveSnowmen = new int[alive];
            int next = 0;
            for (int i = 0; i < snowmen.length; i++) {
                if (snowmen[i] != -1) {
                    aliveSnowmen[next] = snowmen[i];
                    next++;
                }
            }
            snowmen = aliveSnowmen;
        }

    }
}
