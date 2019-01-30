import java.util.Scanner;

public class BeerAndChips {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        double budget = Double.parseDouble(scanner.nextLine());
        int numberOfBeers = Integer.parseInt(scanner.nextLine());
        int numberOfChips = Integer.parseInt(scanner.nextLine());

        double beerPrice = 1.20;
        double moneyForBeers = numberOfBeers * beerPrice;
        double oneChipsPrice = (moneyForBeers * 0.45);
        double allChipsPrice = Math.ceil(numberOfChips * oneChipsPrice);

        double bill = moneyForBeers + allChipsPrice;

        if (budget >= bill) {
            double moneyLeft = budget-(moneyForBeers+allChipsPrice);
            System.out.printf("%s bought a snack and has %.2f leva left.", name, moneyLeft);
        } else {
            double moneyNeeded = bill - budget;
            System.out.printf("%s needs %.2f more leva!", name, moneyNeeded);
        }

    }

}
