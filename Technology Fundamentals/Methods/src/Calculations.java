import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        switch (command) {
            case "add":
                addNumbers(num1, num2);
                break;
            case "subtract":
                subtractNumbers(num1, num2);
                break;
            case "multiply":
                multiplyNumbers(num1, num2);
                break;
            case "divide":
                divideNumbers(num1, num2);
                break;
            default:
                System.out.println("Wrong values kys");
                break;

        }


    }

    public static void addNumbers(int num1, int num2) {
        System.out.println(num1 + num2);
    }

    public static void subtractNumbers(int num1, int num2) {
        System.out.println(num1 - num2);
    }

    public static void multiplyNumbers(int num1, int num2) {
        System.out.println(num1 * num2);
    }

    public static void divideNumbers(int num1, int num2) {
        System.out.println(num1 / num2);
    }
}
