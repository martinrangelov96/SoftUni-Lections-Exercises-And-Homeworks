import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("\\s+");
        int[] numbers = Arrays.asList(input).stream().mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numbers.length ; i++) {
            stack.push(numbers[i]);
        }

        for (int i = numbers.length; i > 0 ; i--) {
            System.out.print(stack.pop() + " ");
        }

    }
}
