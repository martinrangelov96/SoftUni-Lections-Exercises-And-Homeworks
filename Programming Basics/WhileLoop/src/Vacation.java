import java.util.Scanner;

public class Vacation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double moneyNeededForVacation = Double.parseDouble(scanner.nextLine());
        double moneySheHas = Double.parseDouble(scanner.nextLine());

        int spendCounter = 0;
        int dayCounter = 0;

        while (moneySheHas <= moneyNeededForVacation) {
            String spendOrSave = scanner.nextLine();
            double spentOrSaveMoney = Double.parseDouble(scanner.nextLine());
            dayCounter++;

            if ("spend".equals(spendOrSave)) {
                spendCounter++;
                if (spendCounter >= 5) {
                    System.out.println("You can't save the money.");
                    System.out.println(dayCounter);
                    break;
                } else {
                    moneySheHas -= spentOrSaveMoney;
                    if (moneySheHas < spentOrSaveMoney) {
                        moneySheHas = 0;
                    }
                }
            } else if ("save".equals(spendOrSave)) {
                spendCounter = 0;
                moneySheHas += spentOrSaveMoney;
                if (moneySheHas >= moneyNeededForVacation) {
                    System.out.printf("You saved the money for %d days.", dayCounter);
                    break;
                }
            }

            if (moneySheHas >= moneyNeededForVacation) {
                System.out.printf("You saved the money for %d days", dayCounter);
            }
        }

    }

}