import java.util.Scanner;

public class OperationBetweenNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        char ch = scanner.next().charAt(0);
        String evenOrOdd = "";

        int result = 0;
        double doubleResult = 0.0;

        if (ch == '+') {
            result = num1 + num2;
            if (result % 2 == 0) {
                evenOrOdd = "even";
            } else {
                evenOrOdd = "odd";
            }
            System.out.printf("%d %c %d = %d - %s", num1, ch, num2, result, evenOrOdd);
        } else if (ch == '-') {
            result = num1 - num2;
            if (result % 2 == 0) {
                evenOrOdd = "even";
            } else {
                evenOrOdd = "odd";
            }
            System.out.printf("%d %c %d = %d - %s", num1, ch, num2, result, evenOrOdd);
        } else if (ch == '*') {
            result = num1 * num2;
            if (result % 2 == 0) {
                evenOrOdd = "even";
            } else {
                evenOrOdd = "odd";
            }
            System.out.printf("%d %c %d = %d - %s", num1, ch, num2, result, evenOrOdd);
        } else if (ch == '/') {
            if (num2 == 0) {
                System.out.printf("Cannot divide %d by zero", num1);
            } else {
                doubleResult = num1 / (double) num2;
                System.out.printf("%d %c %d = %.2f", num1, ch, num2, doubleResult);
            }
        } else if (ch == '%') {
            if (num2 == 0) {
                System.out.printf("Cannot divide %d by zero", num1);
            } else {
                result = num1 % num2;
                System.out.printf("%d %c %d = %d",num1,ch,num2,result);
            }
        }

    }

}
