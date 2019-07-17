import java.util.Arrays;
import java.util.Scanner;

public class OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (numbers.length % 2 == 0) {
            for (int i = 0; i < numbers.length; i++) {
                int firstNum = numbers[i];
                i++;
                int secondNum = numbers[i];
                if (firstNum % 2 == 0 && secondNum % 2 == 0) {
                    System.out.printf("%d, %d -> both are even%n", firstNum, secondNum);
                } else if (firstNum % 2 == 1 && secondNum % 2 == 1) {
                    System.out.printf("%d, %d -> both are odd%n", firstNum, secondNum);
                } else {
                    System.out.printf("%d, %d -> different%n", firstNum, secondNum);
                }
            }
        } else {
            System.out.println("invalid length");
        }

    }
}
