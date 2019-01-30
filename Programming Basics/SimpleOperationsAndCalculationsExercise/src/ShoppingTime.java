import java.util.Scanner;

public class ShoppingTime {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int breakTime = Integer.parseInt(scanner.nextLine());
        double peripheralPrice = Double.parseDouble(scanner.nextLine());
        double programPrice = Double.parseDouble(scanner.nextLine());
        double whiteFrappePrice = Double.parseDouble(scanner.nextLine());

        int freeTime = (breakTime - (3 * 2) - (2 * 2) - 5);
        double moneySpent = (peripheralPrice * 3) + (programPrice * 2) +whiteFrappePrice;

        System.out.println(String.format("%.2f", moneySpent));
        System.out.println(freeTime);

    }

}
