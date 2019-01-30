import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strNumbers = scanner.nextLine().split(" ");
        int[] numbers = new int[strNumbers.length];

        for (int i = 0; i < strNumbers.length; i++) {
            numbers[i] = Integer.parseInt(strNumbers[i]);
        }

        int maxLength = 1;
        int counter = 1;
        int bestIndex = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i+1]) {
                counter++;
            } else {
                counter = 1;
            }

            if (counter > maxLength) {
                maxLength = counter;
                bestIndex = numbers[i];
            }
        }

        for (int i = 0; i < maxLength ; i++) {
            System.out.print(bestIndex + " ");
        }
        
    }
}
