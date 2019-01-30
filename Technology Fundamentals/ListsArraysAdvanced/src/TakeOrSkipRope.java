import java.util.*;
import java.util.stream.Collectors;

public class TakeOrSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        int minNumber = Integer.MAX_VALUE;
        int maxNumber = Integer.MIN_VALUE;

        if (firstNumbers.size() < secondNumbers.size()) {
            for (int i = 0; i < firstNumbers.size(); i++) {
                result.add(firstNumbers.get(i));
                result.add(secondNumbers.get(secondNumbers.size() - i - 1));
            }
            int firstDigit = secondNumbers.get(0);
            int secondDigit = secondNumbers.get(1);

            minNumber = Math.min(firstDigit, secondDigit);
            maxNumber = Math.max(firstDigit, secondDigit);
        } else {
            for (int i = 0; i < secondNumbers.size(); i++) {
                result.add(firstNumbers.get(i));
                result.add(secondNumbers.get(secondNumbers.size() - i - 1));
            }
            int lastDigit = firstNumbers.get(firstNumbers.size() - 1);
            int secondLastDigit = firstNumbers.get(firstNumbers.size() - 2);

            minNumber = Math.min(secondLastDigit, lastDigit);
            maxNumber = Math.max(secondLastDigit, lastDigit);
        }

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) <= minNumber || result.get(i) >= maxNumber) {
                result.remove(result.get(i));
                i--;
            }
            Collections.sort(result);
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }

    }
}
