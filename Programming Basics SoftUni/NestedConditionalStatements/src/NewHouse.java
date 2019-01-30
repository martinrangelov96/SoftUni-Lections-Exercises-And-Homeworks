import java.util.Scanner;

public class NewHouse {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String flowersType = scanner.nextLine();
        int numberOfFlowers = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double rosesPrice = 5.00;
        double dahliasPrice = 3.80;
        double tulipsPrice = 2.80;
        double narcissusPrice = 3.00;
        double gladiolusPrice = 2.50;

        double price = 0.0;
        double finalPrice = 0.0;
        double discount = 0.0;
        double tax = 0.0;

        if (flowersType.equals("Roses")) {
            if (numberOfFlowers > 80) {
                discount = 0.10;
                price = rosesPrice * numberOfFlowers;
                finalPrice = price - (discount * price);
            } else {
                finalPrice = rosesPrice * numberOfFlowers;
            }
        }

        if (flowersType.equals("Dahlias")) {
            if (numberOfFlowers > 90) {
                discount = 0.15;
                price = dahliasPrice * numberOfFlowers;
                finalPrice = price - (discount * price);
            } else {
                finalPrice = dahliasPrice * numberOfFlowers;
            }
        }

        if (flowersType.equals("Tulips")) {
            if (numberOfFlowers > 80) {
                discount = 0.15;
                price = tulipsPrice * numberOfFlowers;
                finalPrice = price - (discount * price);
            } else {
                finalPrice = tulipsPrice * numberOfFlowers;
            }
        }

        if (flowersType.equals("Narcissus")) {
            if (numberOfFlowers < 120) {
                tax = 0.15;
                price = narcissusPrice * numberOfFlowers;
                finalPrice = price + (price * tax);
            } else {
                finalPrice = narcissusPrice * numberOfFlowers;
            }
        }

        if (flowersType.equals("Gladiolus")) {
            if (numberOfFlowers < 80) {
                tax = 0.20;
                price = gladiolusPrice * numberOfFlowers;
                finalPrice = price + (price * tax);
            } else {
                finalPrice = gladiolusPrice * numberOfFlowers;
            }
        }

        if (budget >= finalPrice) {
            double moneyLeft = Math.abs(budget - finalPrice);
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",
                    numberOfFlowers, flowersType, moneyLeft);
        } else if(budget < finalPrice) {
            double moneyNeeded = Math.abs(finalPrice - budget);
            System.out.printf("Not enough money, you need %.2f leva more.",moneyNeeded);
        }

    }

}
