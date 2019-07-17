import java.util.Scanner;

public class PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers = Integer.parseInt(scanner.nextLine());

        int[] arrayOfNumbers = new int[numbers];

        for (int i = 0; i < numbers ; i++) {
            int arrayNum = Integer.parseInt(scanner.nextLine());
            arrayOfNumbers[i] = arrayNum;
        }

        for (int i = arrayOfNumbers.length - 1; i >= 0 ; i--) {
            System.out.print(arrayOfNumbers[i]+ " ");
        }
    }
}
