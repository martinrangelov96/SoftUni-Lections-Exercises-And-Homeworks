import java.util.Scanner;

public class BakingMasterclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Double budget = Double.parseDouble(scanner.nextLine());
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        Double priceForFlourForAPackage = Double.parseDouble(scanner.nextLine());
        Double priceOfEgg = Double.parseDouble(scanner.nextLine());
        Double priceOfApron = Double.parseDouble(scanner.nextLine());

        double eggsPrice = priceOfEgg * 10 * numberOfStudents;
        double apronsPrice = priceOfApron * (Math.ceil(numberOfStudents + (numberOfStudents * 0.20)));
        int freePackages = numberOfStudents / 5;
        double flourPrice = priceForFlourForAPackage * (numberOfStudents - freePackages);

        double finalPrice = eggsPrice + apronsPrice + flourPrice;

        if (budget >= finalPrice) {
            System.out.printf("Items purchased for %.2f$.", finalPrice);
        } else {
            System.out.printf("%.2f$ more needed.",finalPrice - budget);
        }


    }
}
