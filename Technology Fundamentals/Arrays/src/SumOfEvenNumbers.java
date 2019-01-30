import java.util.Scanner;

public class SumOfEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputNumbers = scanner.nextLine();

        String[] items = inputNumbers.split(" ");

        int sum = 0;

        for (int i = 0; i < items.length ; i++) {
            int number = Integer.parseInt(items[i]);

            if (number % 2 == 0) {
                sum += number;
            }

        }

        System.out.println(sum);

    }
}
