import java.util.Scanner;

public class AccountBalance {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        double sum = 0;

        while (count > 0) {
            double increase = Double.parseDouble(scanner.nextLine());

            if (increase < 0) {
                System.out.println("Invalid operation!");
                break;
            }
            System.out.printf("Increase: %.2f%n", increase);

            sum += increase;
            count--;
        }

        System.out.printf("Total: %.2f", sum);

    }

}
