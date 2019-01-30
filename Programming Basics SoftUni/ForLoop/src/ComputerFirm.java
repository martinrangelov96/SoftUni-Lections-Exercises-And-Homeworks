import java.util.Scanner;

public class ComputerFirm {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfComputers = Integer.parseInt(scanner.nextLine());
        double percentageFromSales = 0.0;
        double sales = 0.0;
        double salesSum = 0.0;
        String length = "";
        int averageRatingSum = 0;


        for (int i = 0; i < numberOfComputers; i++) {
            int ratingAndPossibleSales = Integer.parseInt(scanner.nextLine());
            int ratingAndPossibleSalesLength = (int)(Math.log10(ratingAndPossibleSales)+1);

            if (ratingAndPossibleSales % 10 == 2) {
                averageRatingSum += (ratingAndPossibleSales % 10);
                percentageFromSales = 0;
                length = String.valueOf(ratingAndPossibleSales).substring(0,ratingAndPossibleSalesLength-1);
                sales = Integer.parseInt(length);
                sales *= percentageFromSales;
                salesSum += sales;
            } else if (ratingAndPossibleSales % 10 == 3) {
                averageRatingSum += (ratingAndPossibleSales % 10);
                percentageFromSales = 0.5;
                length = String.valueOf(ratingAndPossibleSales).substring(0,ratingAndPossibleSalesLength-1);
                sales = Integer.parseInt(length);
                sales *= percentageFromSales;
                salesSum += sales;
            } else if (ratingAndPossibleSales % 10 == 4) {
                averageRatingSum += (ratingAndPossibleSales % 10);
                percentageFromSales = 0.7;
                length = String.valueOf(ratingAndPossibleSales).substring(0,ratingAndPossibleSalesLength-1);
                sales = Integer.parseInt(length);
                sales *= percentageFromSales;
                salesSum += sales;
            } else if (ratingAndPossibleSales % 10 == 5) {
                averageRatingSum += (ratingAndPossibleSales % 10);
                percentageFromSales = 0.85;
                length = String.valueOf(ratingAndPossibleSales).substring(0,ratingAndPossibleSalesLength-1);
                sales = Integer.parseInt(length);
                sales *= percentageFromSales;
                salesSum += sales;
            } else  if (ratingAndPossibleSales % 10 == 6) {
                averageRatingSum += (ratingAndPossibleSales % 10);
                percentageFromSales = 1;
                length = String.valueOf(ratingAndPossibleSales).substring(0,ratingAndPossibleSalesLength-1);
                sales = Integer.parseInt(length);
                sales *= percentageFromSales;
                salesSum += sales;
            }

        }

        System.out.printf("%.2f%n",salesSum);
        System.out.printf("%.2f",averageRatingSum * 1.0 / numberOfComputers);

    }

}
