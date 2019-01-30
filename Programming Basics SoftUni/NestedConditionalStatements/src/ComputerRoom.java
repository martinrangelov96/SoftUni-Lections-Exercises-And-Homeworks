import java.util.Scanner;

public class ComputerRoom {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int hoursPlayed = Integer.parseInt(scanner.nextLine());
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String dayOrNight = scanner.nextLine();

        double priceForOnePerson = 0.0;

        switch (month) {
            case "march":
            case "april":
            case "may":
                switch (dayOrNight) {
                    case "day":
                        priceForOnePerson = 10.50;
                        break;
                    case "night":
                        priceForOnePerson = 8.40;
                        break;
                }
                break;
            case "june":
            case "july":
            case "august":
                switch (dayOrNight) {
                    case "day":
                        priceForOnePerson = 12.60;
                        break;
                    case "night":
                        priceForOnePerson = 10.20;
                        break;
                }
                break;
        }

        if (numberOfPeople >= 4) {
            priceForOnePerson = priceForOnePerson * 0.90;
        }
        if (hoursPlayed >= 5) {
            priceForOnePerson = priceForOnePerson * 0.50;
        }

        double totalPrice = priceForOnePerson * numberOfPeople * hoursPlayed;

        System.out.printf("Price per person for one hour: %.2f%n", priceForOnePerson);
        System.out.printf("Total cost of the visit: %.2f", totalPrice);

    }

}