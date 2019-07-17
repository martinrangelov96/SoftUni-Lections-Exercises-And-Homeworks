import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstInput = scanner.nextLine();

        String[] firstNumbers = firstInput.split(" ");
        int firstNumbersLength = firstNumbers.length;
        int[] firstNumbersInt = new int[firstNumbersLength];

        for (int i = 0; i < firstNumbersLength; i++) {
            String firstNumberAsString = firstNumbers[i];
            int firstNumber = Integer.parseInt(firstNumberAsString);
            firstNumbersInt[i] = firstNumber;
        }

        //this (up) == this (down) fml

//        int[] firstNumbersInt = Arrays.stream(scanner.nextLine().split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();

        String secondInput = scanner.nextLine();

        String[] secondNumbers = secondInput.split(" ");
        int secondNumbersLength = secondNumbers.length;
        int[] secondNumbersInt = new int[secondNumbersLength];

        for (int i = 0; i < secondNumbersLength; i++) {
            String secondNumberAsString = secondNumbers[i];
            int firstNumber = Integer.parseInt(secondNumberAsString);
            secondNumbersInt[i] = firstNumber;

        }

        int sum = 0;
        int counter = 0;

        for (int i = 0; i < secondNumbersLength; i++) {
            if (firstNumbersInt[i] == secondNumbersInt[i]) {
                sum += firstNumbersInt[i];
            } else {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                counter++;
                break;
            }

        }

        if (counter == 0) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }

    }
}
