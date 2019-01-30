import java.util.Scanner;

public class WeddingParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfGuests = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        int couvert = 20;
        int money = numberOfGuests * couvert;

        if (budget > money) {
            int moneyLeft = budget - money;
            double moneyForFireworks = moneyLeft * 0.40;
            double moneyForDonation = moneyLeft - moneyForFireworks;
            System.out.printf("Yes! %.0f lv are for fireworks and %.0f lv are for donation.",moneyForFireworks,moneyForDonation);
        } else {
            System.out.printf("They won't have enough money to pay the covert. They will need %d lv more.",money - budget);
        }

    }
}
