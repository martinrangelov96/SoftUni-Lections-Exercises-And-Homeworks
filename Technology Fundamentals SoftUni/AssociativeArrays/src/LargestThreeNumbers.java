import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> biggestIntegers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted((e1,e2) -> e2.compareTo(e1))
                .collect(Collectors.toList());

        for (int i = 0; i < biggestIntegers.size() ; i++) {
            if (i > 2) {
                biggestIntegers.remove(biggestIntegers.get(i));
                i--;
            }
        }

        for (Integer threeBiggestIntegers : biggestIntegers) {
            if (biggestIntegers.size() < 3) {
                System.out.print(threeBiggestIntegers + " ");
            } else {
                System.out.print(threeBiggestIntegers + " ");
            }
        }

    }
}
