import java.util.Scanner;

public class GoingHome {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int distanceInKm = Integer.parseInt(scanner.nextLine());
        int gasolineCostFor100Km = Integer.parseInt(scanner.nextLine());
        double gasolineCostForALiter = Double.parseDouble(scanner.nextLine());
        int tournamentPrize = Integer.parseInt(scanner.nextLine());

        double fuelPrice = ((distanceInKm * gasolineCostFor100Km) / 100.0) * gasolineCostForALiter;

        if (tournamentPrize >= fuelPrice) {
            double moneyLeft = tournamentPrize - fuelPrice;
            System.out.printf("You can go home. %.2f money left.", moneyLeft);
        } else {
            System.out.printf("Sorry, you cannot go home. Each will receive %.2f money.", tournamentPrize / 5.0);
        }

    }

}