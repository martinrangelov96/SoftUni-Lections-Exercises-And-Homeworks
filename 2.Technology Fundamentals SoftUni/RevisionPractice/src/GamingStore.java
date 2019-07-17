import java.util.Scanner;

public class GamingStore {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double moneyYouHave = Double.parseDouble(scanner.nextLine());
        double budget = moneyYouHave;
        String input = scanner.nextLine();

        while (!input.equals("Game Time")) {

            if (input.equals("OutFall 4")) {
                budget -= 39.99;
                if (budget < 0) {
                    System.out.println("Too Expensive");
                    budget += 39.99;
                } else {
                    System.out.println("Bought OutFall 4");
                }
            } else if (input.equals("CS: OG")) {
                budget -= 15.99;
                if (budget < 0) {
                    System.out.println("Too Expensive");
                    budget += 15.99;
                } else {
                    System.out.println("Bought CS: OG");
                }
            } else if (input.equals("Zplinter Zell")) {
                budget -= 19.99;
                if (budget < 0) {
                    System.out.println("Too Expensive");
                    budget += 19.99;
                } else {
                    System.out.println("Bought Zplinter Zell");
                }
            } else if (input.equals("Honored 2")) {
                budget -= 59.99;
                if (budget < 0) {
                    System.out.println("Too Expensive");
                    budget += 59.99;
                } else {
                    System.out.println("Bought Honored 2");
                }
            } else if (input.equals("RoverWatch")) {
                budget -= 29.99;
                if (budget < 0) {
                    System.out.println("Too Expensive");
                    budget += 29.99;
                } else {
                    System.out.println("Bought RoverWatch");
                }
            } else if (input.equals("RoverWatch Origins Edition")) {
                budget -= 39.99;
                if (budget < 0) {
                    System.out.println("Too Expensive");
                    budget += 39.99;
                } else {
                    System.out.println("Bought RoverWatch Origins Edition");
                }
            } else {
                System.out.println("Not Found");
            }

            if (budget == 0) {
                System.out.println("Out of money!");
                break;
            }

            input = scanner.nextLine();
        }

        if (budget != 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", moneyYouHave - budget,budget);
        }

    }

}
