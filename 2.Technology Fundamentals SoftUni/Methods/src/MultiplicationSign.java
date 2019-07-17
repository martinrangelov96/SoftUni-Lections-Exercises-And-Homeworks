import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        multiplicationSign(num1, num2, num3);

    }

    public static void multiplicationSign(int num1, int num2, int num3) {
        if (num1 > 0 && num2 > 0 && num3 > 0) {
            System.out.println("positive");
        }

        if (num1 == 0 || num2 == 0 || num3 == 0) {
            System.out.println("zero");
        }

        int counter = 0;

        if (num1 < 0 || num2 < 0 || num3 < 0) {
            if (num1 < 0) {
                counter++;
            }
            if (num2 < 0) {
                counter++;
            }
            if (num3 < 0) {
                counter++;
            }

            if (counter % 2 == 0) {
                System.out.println("positive");
            } else {
                System.out.println("negative");
            }

        }

    }

}
