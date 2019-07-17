import java.util.Scanner;

public class MatchTickets {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String category = scanner.nextLine();
        int people = Integer.parseInt(scanner.nextLine());

        double vipPrice = 499.99;
        double normalPrice = 249.99;

        double moneyForTransport = 0.0;

        if (people >= 1 && people <= 4) {
            moneyForTransport = budget * 0.75;
        } else if (people >= 5 && people <= 9) {
            moneyForTransport = budget * 0.60;
        } else if (people >= 10 && people <= 24) {
            moneyForTransport = budget * 0.50;
        } else if (people >= 25 && people <= 49) {
            moneyForTransport = budget * 0.40;
        } else if (people >= 50) {
            moneyForTransport = budget * 0.25;
        } else {
            System.out.println("Invalid number of people");
        }

        double moneyLeftForTickets = budget - moneyForTransport;

        double vipTicketsForEveryone = vipPrice * people;
        double normalTicketsForEveryone = normalPrice * people;

        double moneyLeftVip = Math.abs(moneyLeftForTickets - vipTicketsForEveryone);
        double moneyLeftNormal = Math.abs(moneyLeftForTickets - normalTicketsForEveryone);


        if (category.equals("VIP")) {
            if (moneyLeftForTickets >= vipTicketsForEveryone) {
                System.out.printf("Yes! You have %.2f leva left.", moneyLeftVip);
            } else {
                System.out.printf("Not enough money! You need %.2f leva.", moneyLeftVip);
            }
        } else if (category.equals("Normal")) {
            if (moneyLeftForTickets >= normalTicketsForEveryone) {
                System.out.printf("Yes! You have %.2f leva left.", moneyLeftNormal);
            } else {
                System.out.printf("Not enough money! You need %.2f leva.", moneyLeftNormal);
            }
        }

    }

}
