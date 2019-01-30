import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNumber = Double.parseDouble(scanner.nextLine());
        double secondNumber = Double.parseDouble(scanner.nextLine());

        double divisionResult = calculateFactorial(firstNumber) / calculateFactorial(secondNumber);

        System.out.printf("%.2f",divisionResult);

    }

    public static double calculateFactorial(double number) {
        double sum = 1;
        while(number > 0) {

            sum *= number;

            number--;
        }
        return sum;
    }

}
