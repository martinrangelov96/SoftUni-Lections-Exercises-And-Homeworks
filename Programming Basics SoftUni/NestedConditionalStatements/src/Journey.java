import java.util.Scanner;

public class Journey {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String placeToStay = "";
        double percentSpentFromBudget = 0.0;
        double moneySpent = 0.0;

        switch (season) {
            case "summer":
                placeToStay = "Camp";
                break;
            case "winter":
                placeToStay = "Hotel";
                break;
                default:
                    System.out.println("Wrong input");
        }

        if (budget <= 100) {
            if (season.equals("summer")) {
                percentSpentFromBudget = 0.30;
                moneySpent = budget * percentSpentFromBudget;
                System.out.println("Somewhere in Bulgaria");
            } else if (season.equals("winter")) {
                percentSpentFromBudget = 0.70;
                moneySpent = budget * percentSpentFromBudget;
                System.out.println("Somewhere in Bulgaria");
            }
        } else if(budget > 100 && budget <= 1000) {
            if (season.equals("summer")) {
                percentSpentFromBudget = 0.40;
                moneySpent = budget * percentSpentFromBudget;
                System.out.println("Somewhere in Balkans");
            } else if (season.equals("winter")) {
                percentSpentFromBudget = 0.80;
                moneySpent = budget * percentSpentFromBudget;
                System.out.println("Somewhere in Balkans");
            }
        } else {
            placeToStay = "Hotel";
            percentSpentFromBudget = 0.90;
            moneySpent = budget * percentSpentFromBudget;
            System.out.println("Somewhere in Europe");
        }

        System.out.printf("%s - %.2f ",placeToStay, moneySpent);

    }

}
