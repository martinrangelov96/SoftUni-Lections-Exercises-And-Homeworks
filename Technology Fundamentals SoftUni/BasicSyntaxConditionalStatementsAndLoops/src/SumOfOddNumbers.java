import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int oddNumber = 1; oddNumber <= (number * 2) - 1 ; oddNumber+=2) {
            System.out.println(oddNumber);
            sum += oddNumber;
        }

        System.out.println("Sum: "+sum);

    }
}
