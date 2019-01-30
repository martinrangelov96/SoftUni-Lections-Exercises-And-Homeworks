import java.util.Scanner;

public class WeddingInvestment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String term = scanner.nextLine();
        String termType = scanner.nextLine();
        String desertOrNo = scanner.nextLine();
        int numberOfMonths = Integer.parseInt(scanner.nextLine());

        double price = 0.0;

        if (term.equals("one")) {
            switch (termType) {
                case "Small":
                    price = 9.98;
                    break;
                case "Middle":
                    price = 18.99;
                    break;
                case "Large":
                    price = 25.98;
                    break;
                case "ExtraLarge":
                    price = 35.99;
                    break;
                default:
                    break;
            }
        } else if (term.equals("two")) {
            switch (termType) {
                case "Small":
                    price = 8.58;
                    break;
                case "Middle":
                    price = 17.09;
                    break;
                case "Large":
                    price = 23.59;
                    break;
                case "ExtraLarge":
                    price = 31.79;
                    break;
                default:
                    break;
            }
        }

        switch (desertOrNo) {
            case "yes":
                if (price <= 10) {
                    price += 5.50;
                } else if (price <= 30) {
                    price += 4.35;
                } else if (price > 30) {
                    price += 3.85;
                }
        }

        if (term.equals("two")) {
            price *= 0.9625;
        }

        double finalPrice = price * numberOfMonths;

        System.out.printf("%.2f lv.", finalPrice);

    }
}
