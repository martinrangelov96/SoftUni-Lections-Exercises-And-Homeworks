import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<String> text = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            int sum = 0;
            int testNumber = numbers.get(i);
            int numLength = String.valueOf(numbers.get(i)).length();
            for (int j = 0; j < numLength; j++) {
                sum += testNumber % 10;
                testNumber /= 10;

            }
            if (sum < text.size()) {
                System.out.print(text.get(sum));
                text.remove(text.get(sum));
            } else {
                System.out.print(text.get(sum - text.size()));
                text.remove(sum - text.size());
            }
        }

    }
}
