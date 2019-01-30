import java.util.Scanner;

public class Travelling {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {
            String input = scanner.nextLine();
            if (input.equals("End")) {
                break;
            }

            double moneyNeeded = Double.parseDouble(scanner.nextLine());
            double savedMoneySum = 0;

            while (moneyNeeded > savedMoneySum) {
                double savedMoney = Double.parseDouble(scanner.nextLine());
                savedMoneySum += savedMoney;
            }
            System.out.printf("Going to %s!%n", input);

        }

    }

}
