import java.util.Scanner;

public class ComputerFirmSimpler {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfComputers = Integer.parseInt(scanner.nextLine());

        double totalRate = 0;
        double totalSales = 0;

        for (int i = 0; i < numberOfComputers; i++) {
            int computerRatingAndSales = Integer.parseInt(scanner.nextLine());

            int computerRating = computerRatingAndSales % 10;
            int computerSales = computerRatingAndSales / 10;

            totalRate += computerRating;

            if (computerRating == 2) {
                totalSales += 0;
            } else if (computerRating == 3) {
                totalSales += computerSales * 0.5;
            } else if (computerRating == 4) {
                totalSales += computerSales * 0.7;
            } else if (computerRating == 5) {
                totalSales += computerSales * 0.85;
            } else if (computerRating == 6) {
                totalSales += computerSales;
            }

        }

        double averageRating = totalRate * 1.0 /numberOfComputers;
        System.out.printf("%.2f%n",totalSales);
        System.out.printf("%.2f",averageRating);


    }

}
