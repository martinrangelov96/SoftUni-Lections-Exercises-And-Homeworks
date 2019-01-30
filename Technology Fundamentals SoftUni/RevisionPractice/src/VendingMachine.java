import java.util.Scanner;

public class VendingMachine {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double sumMoney = 0;
        double foodPrice = 0;

        while (!input.equals("Start")) {
            double money = Double.parseDouble(input);
            if (money == 0.1 || money == 0.2 || money == 0.5 || money == 1 || money == 2) {
                sumMoney += money;
            } else {
                System.out.printf("Cannot accept %.2f%n", money);
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("End")) {
            if (input.equals("Nuts")) {
                foodPrice += 2.0;
                if (sumMoney < foodPrice) {
                    System.out.println("Sorry, not enough money");
                    foodPrice -= 2.0;
                } else {
                    System.out.println("Purchased Nuts");
                }
            } else if (input.equals("Water")) {
                foodPrice += 0.7;
                if (sumMoney < foodPrice) {
                    System.out.println("Sorry, not enough money");
                    foodPrice -= 0.7;
                } else {
                    System.out.println("Purchased Water");
                }
            } else if (input.equals("Crisps")) {
                foodPrice += 1.5;
                if (sumMoney < foodPrice) {
                    System.out.println("Sorry, not enough money");
                    foodPrice -= 1.5;
                } else {
                    System.out.println("Purchased Crisps");
                }
            } else if (input.equals("Soda")) {
                foodPrice += 0.8;
                if (sumMoney < foodPrice) {
                    System.out.println("Sorry, not enough money");
                    foodPrice -= 0.8;
                } else {
                    System.out.println("Purchased Soda");
                }
            } else if (input.equals("Coke")) {
                foodPrice += 1.0;
                if (sumMoney < foodPrice) {
                    System.out.println("Sorry, not enough money");
                    foodPrice -= 1.0;
                } else {
                    System.out.println("Purchased Coke");
                }
            } else {
                System.out.println("Invalid product");
            }

            input = scanner.nextLine();
        }

        System.out.printf("Change: %.2f",sumMoney - foodPrice);

    }

}
