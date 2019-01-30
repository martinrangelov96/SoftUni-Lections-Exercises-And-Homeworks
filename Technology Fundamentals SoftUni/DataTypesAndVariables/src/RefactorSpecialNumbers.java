import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sumOfNumbers = 0;
        int number = 0;
        boolean isSpecial = false;
        for (int ch = 1; ch <= n; ch++) {
            number = ch;
            while (ch > 0) {
                sumOfNumbers += ch % 10;
                ch = ch / 10;
            }
            isSpecial = (sumOfNumbers == 5) || (sumOfNumbers == 7) || (sumOfNumbers == 11);
            String trueOrFalse = String.valueOf(isSpecial);
            System.out.printf("%d -> %s%n", number, trueOrFalse.substring(0,1).toUpperCase() + trueOrFalse.substring(1));
            sumOfNumbers = 0;
            ch = number;
        }


    }
}
