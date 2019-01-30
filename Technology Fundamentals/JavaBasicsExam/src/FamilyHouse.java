import java.util.Scanner;

public class FamilyHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int waterBill = 20;
        int internetBill = 15;

        int numberOfMonths = Integer.parseInt(scanner.nextLine());
        double electricityBill = 0.0;
        double electricitySum = 0.0;

        for (int i = 0; i < numberOfMonths; i++) {
            electricityBill = Double.parseDouble(scanner.nextLine());
            electricitySum += electricityBill;
        }

        double waterBillSum = waterBill * numberOfMonths;
        double internetBillSum = internetBill * numberOfMonths;

        double billsSum = electricitySum + waterBillSum + internetBillSum;

        double otherSum = billsSum * 1.20;

        double billsSumTotal = billsSum + otherSum;

        double averageBill = billsSumTotal / numberOfMonths;

        System.out.printf("Electricity: %.2f lv%n",electricitySum);
        System.out.printf("Water: %.2f lv%n",waterBillSum);
        System.out.printf("Internet: %.2f lv%n",internetBillSum);
        System.out.printf("Other: %.2f lv%n",otherSum);
        System.out.printf("Average: %.2f lv%n",averageBill);

    }
}
