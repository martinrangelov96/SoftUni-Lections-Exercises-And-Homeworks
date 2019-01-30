import java.text.DecimalFormat;
import java.util.Scanner;

public class StadiumIncome {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfSectors = Integer.parseInt(scanner.nextLine());
        int stadiumCapacity = Integer.parseInt(scanner.nextLine());
        double ticketPrice = Double.parseDouble(scanner.nextLine());

        double oneSectorIncome = ((stadiumCapacity*ticketPrice) / numberOfSectors);
        double totalIncome = numberOfSectors * oneSectorIncome;
        double charityMoney = (totalIncome - (0.75 * oneSectorIncome)) * 1/8;

        System.out.println("Total income - " +String.format("%.2f", totalIncome) + " BGN");
        System.out.println("Money for charity - " +String.format("%.2f", charityMoney) + " BGN");

    }

}
