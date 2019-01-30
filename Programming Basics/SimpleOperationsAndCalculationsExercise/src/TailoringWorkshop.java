import java.util.Scanner;

public class TailoringWorkshop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfTables = Integer.parseInt(scanner.nextLine());
        double lengthOfTables = Double.parseDouble(scanner.nextLine());
        double widthOfTables = Double.parseDouble(scanner.nextLine());

        double coverMeters =(numberOfTables * (lengthOfTables + 2 * 0.30) * (widthOfTables + 2 * 0.30));
        double squareMeters = (numberOfTables * (lengthOfTables/2) * (lengthOfTables/2));

        System.out.println(String.format("%.2f", (coverMeters * 7) + (squareMeters * 9)) + " USD ");
        System.out.println(String.format("%.2f", ((coverMeters * 7) + (squareMeters * 9)) * 1.85    ) + " BGN ");


    }

}
