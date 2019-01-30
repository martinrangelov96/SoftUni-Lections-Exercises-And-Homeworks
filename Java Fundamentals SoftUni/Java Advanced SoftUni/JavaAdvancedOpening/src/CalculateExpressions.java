import java.util.Scanner;

public class CalculateExpressions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputNumbers = scanner.nextLine().split("\\s++");

        double a = Double.parseDouble(inputNumbers[0]);
        double b = Double.parseDouble(inputNumbers[1]);
        double c = Double.parseDouble(inputNumbers[2]);

        double f1FirstExpression = (Math.pow(a,2) + Math.pow(b,2)) / ((Math.pow(a,2)) - Math.pow(b, 2));
        double f1SecondExpression = ((a + b + c)) / (Math.sqrt(c));
        double f1FinalResult = Math.pow(f1FirstExpression,f1SecondExpression);

        double f2FirstExpression = (Math.pow(a,2) + Math.pow(b,2) - Math.pow(c, 3));
        double f2SecondExpression = (a - b);
        double f2FinalExpression = Math.pow(f2FirstExpression, f2SecondExpression);

        double averageOfTheThreeNumbers = (a + b + c) / 3;
        double averageOfTheTwoExpressions = (f1FinalResult + f2FinalExpression) / 2;
        double difference = Math.abs(averageOfTheThreeNumbers - averageOfTheTwoExpressions);

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1FinalResult, f2FinalExpression, difference);

    }
}
