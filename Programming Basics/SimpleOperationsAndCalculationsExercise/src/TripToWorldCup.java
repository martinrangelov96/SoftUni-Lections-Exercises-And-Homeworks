import java.util.Scanner;

public class TripToWorldCup {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double ticketGo = Double.parseDouble(scanner.nextLine());
        double ticketBack = Double.parseDouble(scanner.nextLine());
        double oneGameTicket = Double.parseDouble(scanner.nextLine());
        double numberOfGames = Double.parseDouble(scanner.nextLine());
        double percentageDiscount = Double.parseDouble(scanner.nextLine());

        int numberOfPeople = 6;
        double travelMoneyForAllNoDiscount = numberOfPeople * (ticketGo + ticketBack);
        double travelMoneyForAllWithDiscount = travelMoneyForAllNoDiscount - (travelMoneyForAllNoDiscount * (percentageDiscount/100));

        double ticketPricesForAll = (numberOfPeople * (oneGameTicket * numberOfGames));
        double totalMoneyForAll = travelMoneyForAllWithDiscount + ticketPricesForAll;
        double totalMoneyForEach = totalMoneyForAll/numberOfPeople;

        System.out.println("Total sum: " +String.format("%.2f",totalMoneyForAll) + " lv.");
        System.out.println("Each friend has to pay " +String.format("%.2f",totalMoneyForEach) + " lv.");

    }

}
