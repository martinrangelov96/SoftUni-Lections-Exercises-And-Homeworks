import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while(!firstPlayerCards.isEmpty() && !secondPlayerCards.isEmpty()) {

            if (firstPlayerCards.get(0) > secondPlayerCards.get(0)) {
                firstPlayerCards.add(firstPlayerCards.size(), secondPlayerCards.get(0));
                firstPlayerCards.add(firstPlayerCards.size() - 1, firstPlayerCards.get(0));
                firstPlayerCards.remove(0);
                secondPlayerCards.remove(0);
            } else if (firstPlayerCards.get(0) < secondPlayerCards.get(0)) {
                secondPlayerCards.add(secondPlayerCards.size(), firstPlayerCards.get(0));
                secondPlayerCards.add(secondPlayerCards.size() - 1, secondPlayerCards.get(0));
                secondPlayerCards.remove(0);
                firstPlayerCards.remove(0);
            } else {
                firstPlayerCards.remove(0);
                secondPlayerCards.remove(0);
            }
        }

        if (!firstPlayerCards.isEmpty()) {
            int sum = 0;
            for(int nums : firstPlayerCards) {
                sum += nums;
            }
            System.out.printf("First player wins! Sum: %d%n",sum);
        } else {
            int sum = 0;
            for(int nums : secondPlayerCards) {
                sum += nums;
            }
            System.out.printf("Second player wins! Sum: %d%n",sum);
        }

    }
}
