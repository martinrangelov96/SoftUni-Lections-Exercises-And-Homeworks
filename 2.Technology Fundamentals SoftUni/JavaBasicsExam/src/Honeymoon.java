import java.util.Scanner;

public class Honeymoon {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String city = scanner.nextLine();
        int nightStands = Integer.parseInt(scanner.nextLine());

        double price = 0;
        double moneyLeft = 0;
        double cairoPrice = (250 * 2 * nightStands) + 600;
        double parisPrice = (150 * 2 * nightStands) + 350;
        double limaPrice = (400 * 2 * nightStands) + 850;
        double newYorkPrice = (300 * 2 * nightStands) + 650;
        double tokyoPrice = (350 * 2 * nightStands) + 700;


        if (city.equals("Cairo")) {
            if (nightStands >= 1 && nightStands <= 4) {
                cairoPrice *= 0.97;
            } else if (nightStands >= 5 && nightStands <= 9) {
                cairoPrice *= 0.95;
            } else if (nightStands >= 10 && nightStands <= 24) {
                cairoPrice *= 0.90;
            } else if (nightStands >= 25 && nightStands <= 49) {
                cairoPrice *= 0.83;
            } else if (nightStands >= 50) {
                cairoPrice *= 0.70;
            }
            moneyLeft = budget - cairoPrice;
            price = cairoPrice;
        } else if (city.equals("Paris")) {
            if (nightStands >= 5 && nightStands <= 9) {
                parisPrice *= 0.93;
            } else if (nightStands >= 10 && nightStands <= 24) {
                parisPrice *= 0.88;
            } else if (nightStands >= 25 && nightStands <= 49) {
                parisPrice *= 0.78;
            } else if (nightStands >= 50) {
                parisPrice *= 0.70;
            }
            moneyLeft = budget - parisPrice;
            price = parisPrice;
        } else if (city.equals("Lima")) {
            if (nightStands >= 25 && nightStands <= 49) {
                limaPrice *= 0.81;
            } else if (nightStands >= 50) {
                limaPrice *= 0.70;
            }
            moneyLeft = budget - limaPrice;
            price = limaPrice;
        } else if (city.equals("New York")) {
            if (nightStands >= 1 && nightStands <= 4) {
                newYorkPrice *= 0.97;
            } else if (nightStands >= 5 && nightStands <= 9) {
                newYorkPrice *= 0.95;
            } else if (nightStands >= 10 && nightStands <= 24) {
                newYorkPrice *= 0.88;
            } else if (nightStands >= 25 && nightStands <= 49) {
                newYorkPrice *= 0.81;
            } else if (nightStands >= 50) {
                newYorkPrice *= 0.70;
            }
            moneyLeft = budget - newYorkPrice;
            price = newYorkPrice;
        } else if (city.equals("Tokyo")) {
            if (nightStands >= 10 && nightStands <= 24) {
                tokyoPrice *= 0.88;
            } else if (nightStands >= 25 && nightStands <= 49) {
                tokyoPrice *= 0.83;
            } else if (nightStands >= 50) {
                tokyoPrice *= 0.70;
            }
            moneyLeft = budget - tokyoPrice;
            price = tokyoPrice;
        }

        if (budget > price) {
            System.out.printf("Yes! You have %.2f leva left.", moneyLeft);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", price - budget);
        }

    }
}
