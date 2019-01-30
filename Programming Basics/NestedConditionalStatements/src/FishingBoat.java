import java.util.Scanner;

public class FishingBoat {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int numberOfFishermen = Integer.parseInt(scanner.nextLine());

        double discountFrom0To6 = 0.10;
        double discountFrom7To11 = 0.15;
        double discountOver12 = 0.25;

        double price = 0.0;
        double rent = 0.0;

        switch (season) {
            case "Spring":
                rent = 3000;
                break;
            case "Summer":
                rent = 4200;
                break;
            case "Autumn":
                rent = 4200;
                break;
            case "Winter":
                rent = 2600;
                break;
                default:
                    System.out.println("Wrong season!");
        }

        if (numberOfFishermen <= 6) {
            price = rent - (rent * discountFrom0To6);
        } else if(numberOfFishermen >= 7 && numberOfFishermen <= 11) {
            price = rent - (rent * discountFrom7To11);
        } else if(numberOfFishermen >= 12) {
            price = rent - (rent * discountOver12);
        }

        if (numberOfFishermen % 2 == 0 && !season.equals("Autumn")) {
            double evenFishermenAndNoAutumnSeason = 0.05;
            price = price - (price * evenFishermenAndNoAutumnSeason);
        }

        if (budget >= price) {
            double moneyLeft = budget - price;
            System.out.printf("Yes! You have %.2f leva left.",moneyLeft);
        } else {
            double moneyNeeded = price - budget;
            System.out.printf("Not enough money! You need %.2f leva.", moneyNeeded);
        }

    }

}
