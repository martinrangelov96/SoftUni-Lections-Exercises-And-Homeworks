import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputNumbers = scanner.nextLine();

        String[] arrayOfNumbers = inputNumbers.split(" ");

        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < arrayOfNumbers.length ; i++) {
            int number = Integer.parseInt(arrayOfNumbers[i]);

            if (number % 2 == 1) {
                oddSum += number;
            } else {
                evenSum += number;
            }
        }

        System.out.println(evenSum - oddSum);

    }
}
