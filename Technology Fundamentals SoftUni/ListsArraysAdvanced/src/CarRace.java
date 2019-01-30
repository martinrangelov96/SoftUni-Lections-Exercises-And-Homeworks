import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> carSpeedNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        double leftCarSpeedSum = 0;
        double rightCarSpeedSum = 0;

        for (int i = 0; i < carSpeedNumbers.size() / 2; i++) {
            if (carSpeedNumbers.get(i) == 0) {
                leftCarSpeedSum *= 0.8;
            } else {
                leftCarSpeedSum += carSpeedNumbers.get(i);
            }
        }


        for (int i = carSpeedNumbers.size() - 1; i > carSpeedNumbers.size() / 2; i--) {
            if (carSpeedNumbers.get(i) == 0) {
                rightCarSpeedSum *= 0.8;
            } else {
                rightCarSpeedSum += carSpeedNumbers.get(i);
            }
        }

        if (leftCarSpeedSum < rightCarSpeedSum) {
            System.out.printf("The winner is left with total time: %.1f",leftCarSpeedSum);
        } else {
            System.out.printf("The winner is right with total time: %.1f",rightCarSpeedSum);
        }


    }
}
