import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> specialNumberAndPower = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int specialNumber = specialNumberAndPower.get(0);
        int power = specialNumberAndPower.get(1);

        if (numbers.contains(specialNumber)) {
            while (numbers.contains(specialNumber)) {
                int specialNumberIndex = numbers.indexOf(specialNumber);

                for (int i = 0; i < power; i++) {

                    if (specialNumberIndex - 1 >= 0) {
                        numbers.remove(specialNumberIndex - 1);
                    } else {
                        continue;
                    }

                    specialNumberIndex--;

                    if (specialNumberIndex + 1 < numbers.size()) {
                        numbers.remove(specialNumberIndex + 1);
                    }
                }
                numbers.remove(specialNumberIndex);
            }
        } else {
            return;
        }

        int sum = 0;

        for (int nums : numbers) {
            sum += nums;
        }

        System.out.println(sum);

    }
}
