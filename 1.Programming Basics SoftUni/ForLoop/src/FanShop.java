import java.util.Scanner;

public class FanShop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        int numberOfItems = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfItems; i++) {
            String item = scanner.nextLine();

            if (item.equals("hoodie")) {
                budget -= 30;
            } else if (item.equals("keychain")) {
                budget -= 4;
            } else if (item.equals("T-shirt")) {
                budget -= 20;
            } else if (item.equals("flag")) {
                budget -= 15;
            } else if (item.equals("sticker")) {
                budget -= 1;
            }

        }

        if (budget >= 0) {
            System.out.printf("You bought %d items and left with %d lv.",numberOfItems, budget);
        } else {
            System.out.printf("Not enough money, you need %d more lv.", Math.abs(budget));
        }

    }

}
