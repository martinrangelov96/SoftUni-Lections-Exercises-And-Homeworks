import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        int index = 0;

        if (firstNumbers.size() < secondNumbers.size()) {
            for (int i = 0; i < firstNumbers.size() ; i++) {
                result.add(firstNumbers.get(i));
                result.add(secondNumbers.get(i));
                index = i;
            }
            for (int i = index + 1; i < secondNumbers.size() ; i++) {
                result.add(secondNumbers.get(i));
            }
        } else {
            for (int i = 0; i < secondNumbers.size() ; i++) {
                result.add(firstNumbers.get(i));
                result.add(secondNumbers.get(i));
                index = i;
            }
            for (int i = index + 1; i < firstNumbers.size() ; i++) {
                result.add(firstNumbers.get(i));
            }
        }

        result.forEach(e -> System.out.print(e + " "));

    }
}
