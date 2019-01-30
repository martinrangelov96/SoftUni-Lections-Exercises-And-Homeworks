import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersRange = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numbersRange; i++) {
            if (isTopNumber(i)) {
                System.out.println(i);
            }
        }

    }

    public static boolean isTopNumber(int numbersRange) {
        boolean isSumOfDigitsDivisibleByEight = validateDivisibility(numbersRange);
        boolean hasAtLeastOneOddDigit = validateIfHasAtLeastOneOddDigit(numbersRange);

        return isSumOfDigitsDivisibleByEight && hasAtLeastOneOddDigit;
    }

    private static boolean validateIfHasAtLeastOneOddDigit(int number) {
        String numberAsString = String.valueOf(number);
        for (int i = 0; i < numberAsString.length(); i++) {
            if (numberAsString.charAt(i) == '1'
                    || numberAsString.charAt(i) == '3'
                    || numberAsString.charAt(i) == '5'
                    || numberAsString.charAt(i) == '7'
                    || numberAsString.charAt(i) == '9'
            ) {
                return true;
            }
        }
        return false;
    }

    private static boolean validateDivisibility(int number) {
        String numberAsStr = String.valueOf(number);
        int sum = 0;
        for (int i = 0; i < numberAsStr.length(); i++) {
            sum += number % 10;
            number /= 10;
        }

        if (sum % 8 == 0) {
            return true;
        }

        return false;
    }

}
