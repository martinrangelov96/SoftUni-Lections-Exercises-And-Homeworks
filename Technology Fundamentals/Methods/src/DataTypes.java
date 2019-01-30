import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if (input.equals("int")) {
            int intNumber = Integer.parseInt(scanner.nextLine());
            System.out.println(returnSomething(intNumber));
        } else if (input.equals("real")) {
            double doubleNumber = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.2f%n", returnSomething(doubleNumber));
        } else {
            String stringText = scanner.nextLine();
            System.out.println("$" + returnSomething(stringText) + "$");
        }

    }

    public static int returnSomething(int number) {
        return number * 2;
    }

    public static double returnSomething(double number) {
        return number * 1.5;

    }

    public static String returnSomething(String text) {
        return text;
    }

}
