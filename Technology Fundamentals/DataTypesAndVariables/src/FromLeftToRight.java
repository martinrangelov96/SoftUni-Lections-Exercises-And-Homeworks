import java.util.Scanner;

public class FromLeftToRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers = Integer.parseInt(scanner.nextLine());

        int numbersSum = 0;
        int firstNumFinalSum = 0;
        String twoNumbersAsString = "";

        int j = 0;

        for (int i = 0; i < numbers; i++) {
            if (j == twoNumbersAsString.length() && j != 0) {
                if (firstNumFinalSum > numbersSum) {
                    System.out.println(firstNumFinalSum);
                } else {
                    System.out.println(numbersSum);
                }
            }
            twoNumbersAsString = scanner.nextLine();
            numbersSum = 0;
            for (j = 0; j < twoNumbersAsString.length(); j++) {

                if (twoNumbersAsString.charAt(j) == '-') {
                    numbersSum -= twoNumbersAsString.charAt(j+1) - '0';
                    j++;
                    continue;
                }
                if (twoNumbersAsString.charAt(j) == ' ') {
                    firstNumFinalSum = numbersSum;
                    numbersSum = 0;
                    continue;
                }
                numbersSum += twoNumbersAsString.charAt(j) - '0';
            }

        }

        if (firstNumFinalSum > numbersSum) {
            System.out.println(firstNumFinalSum);
        } else {
            System.out.println(numbersSum);
        }

    }
}
