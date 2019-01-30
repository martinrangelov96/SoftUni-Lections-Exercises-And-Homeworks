import java.util.Scanner;

public class DailyEarnings {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int workingDaysInMonth = Integer.parseInt(scanner.nextLine());
        double dollarsInADayEarned = Double.parseDouble(scanner.nextLine());
        double dollarsInLeva = Double.parseDouble(scanner.nextLine());

        double dollarsInMonthEarned = workingDaysInMonth * dollarsInADayEarned;
        double bonusSalary = dollarsInMonthEarned * 2.5;
        double dollarsInYearEarnedNoTax = (dollarsInMonthEarned * 12) + bonusSalary;
        double taxes = dollarsInYearEarnedNoTax * 0.25;
        double dollarsInYearEarnedWithTax = dollarsInYearEarnedNoTax - taxes;

        double dailyEarnings = dollarsInYearEarnedWithTax / 365;
        double dailyEarningsInLeva = dailyEarnings * dollarsInLeva;

        System.out.printf("%.2f", dailyEarningsInLeva);


    }

}
