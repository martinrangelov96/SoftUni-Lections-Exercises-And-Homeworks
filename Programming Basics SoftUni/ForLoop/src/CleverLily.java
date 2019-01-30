import java.util.Scanner;

public class CleverLily {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double priceW = Double.parseDouble(scanner.nextLine());
        int priceToy = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        int money = 10;
        int countToy = 0;
        int countBrother = 0;

        for (int i = 1; i <= age; i++) {
            if (i % 2 == 0) {
                sum += money;
                money += 10;
                countBrother++;
            } else {
                countToy++;
            }
        }

        double saveMoney = (sum - countBrother) + (countToy * priceToy);

        if (saveMoney >= priceW) {
            System.out.printf("Yes! %.2f", saveMoney - priceW);
        } else {
            System.out.printf("No! %.2f", Math.abs(saveMoney - priceW));
        }

    }

}
