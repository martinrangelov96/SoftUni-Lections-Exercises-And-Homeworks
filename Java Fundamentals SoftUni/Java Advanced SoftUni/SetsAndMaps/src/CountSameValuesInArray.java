import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountSameValuesInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");

        Map<String, Integer> numbers = new HashMap<>();

        for (String num : arr) {
            if (!numbers.containsKey(num + "")) {
                numbers.put(num + "", 0);
            }

            numbers.put(num + "", numbers.get(num + "") + 1);
        }

        for (Map.Entry<String, Integer> entry : numbers.entrySet()) {
            System.out.printf("%s - %d times%n", entry.getKey(), entry.getValue());
        }

    }
}
