import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int multipleOfEvensAndOdds = Math.abs(getMultipleOfEvensAndOdds(number));

        System.out.println(multipleOfEvensAndOdds);


    }

    public static int getMultipleOfEvensAndOdds(int number) {
        return getSumOfEvenDigits(Math.abs(number)) * getSumOfOddDigits(Math.abs(number));
    }

    public static int getSumOfEvenDigits(int number) {
        int evenSum = 0;

        while (Math.abs(number) > 1) {
            if (number % 2 == 0) {
                evenSum += Math.abs(number % 10);
            }
            number /= 10;
        }

        return Math.abs(evenSum);

    }

    public static int getSumOfOddDigits(int number) {
        int oddSum = 0;

        while (Math.abs(number) > 0) {
            if (number % 2 == 1) {
                oddSum += Math.abs(number % 10);
            }
            number /= 10;
        }

        return Math.abs(oddSum);

    }

}
