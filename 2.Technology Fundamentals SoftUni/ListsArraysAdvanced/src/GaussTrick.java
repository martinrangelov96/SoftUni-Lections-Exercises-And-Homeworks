import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (numbers.size() % 2 == 0) {
            for (int i = 0; i < numbers.size() / 2; i++) {
                int evenSum = numbers.get(i) + numbers.get(numbers.size() - 1 - i);
                System.out.print(evenSum + " ");
            }
        } else {
            for (int i = 0; i < (numbers.size() / 2) + 1; i++) {
                if (i == numbers.size() / 2 && i != 0) {
                    System.out.print(numbers.get(i));
                    break;
                }
                int oddSum = numbers.get(i) + numbers.get(numbers.size() - 1 - i);
                System.out.print(oddSum + " ");
            }
        }

    }
}
