import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int num2 = Integer.parseInt(scanner.nextLine());

        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        double result = doCalculation(num1, operator, num2);

        System.out.println(decimalFormat.format(result));

    }

    public static double doCalculation(int num1, String operator, int num2) {
        if (operator.equals("*")) {
            return num1 * num2;
        } else if (operator.equals("/")) {
            return num1 / num2;
        } else if (operator.equals("+")) {
            return num1 + num2;
        } else return num1 - num2;
    }

}
