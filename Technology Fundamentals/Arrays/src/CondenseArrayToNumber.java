import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] splittedNumbers = input.split(" ");
        int numbersLength = splittedNumbers.length;
        int[] numbersArray = new int[numbersLength];

        for (int i = 0; i < numbersLength; i++) {
            String numbersAsString = splittedNumbers[i];
            int numbersAsInt = Integer.parseInt(numbersAsString);
            numbersArray[i] = numbersAsInt;
        }

        int[] condensed = new int[numbersArray.length - 1];

        for (int i = 0; i < numbersLength; i++) {
            for (int j = 0; j < numbersLength - 1; j++) {
                condensed[j] = numbersArray[j] + numbersArray[j + 1];
                numbersArray = condensed;
            }
        }
    }

//        int condensedSum = 0;
//
//        for (int i = 0; i < condensed.length ; i++) {
//            condensedSum += condensed[i];
//        }
//
//        System.out.println(condensedSum);

}

