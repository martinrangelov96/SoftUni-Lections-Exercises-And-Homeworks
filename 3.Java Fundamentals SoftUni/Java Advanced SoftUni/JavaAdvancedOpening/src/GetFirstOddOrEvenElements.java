import java.util.Arrays;
import java.util.Scanner;

public class GetFirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[] getInput = scanner.nextLine().split(" ");

        int numberOfNumbers = Integer.parseInt(getInput[1]);
        String oddOrEven = getInput[2];
        int counter = 0;

        if (oddOrEven.equals("odd")) {
                for (int number : numbers) {
                    if (counter == numberOfNumbers) {
                        break;
                    }
                    if (number % 2 != 0) {
                        counter++;
                        System.out.printf("%d ",number);
                    }
                }
        } else if (oddOrEven.equals("even")) {
            for (int number : numbers) {
                if (counter == numberOfNumbers) {
                    break;
                }
                if (number % 2 == 0) {
                    counter++;
                    System.out.printf("%d ",number);
                }
            }
        }

    }
}
