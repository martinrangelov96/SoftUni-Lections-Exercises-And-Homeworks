import java.util.Scanner;

public class RefactoringPrimeChecker {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int untilNumber = Integer.parseInt(scanner.nextLine());

        for (int num = 2; num <= untilNumber; num++) {
            boolean isItPrime = true;
            for (int secondNum = 2; secondNum < num; secondNum++) {
                if (num % secondNum == 0) {
                    isItPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", num, isItPrime);
        }

    }
}
