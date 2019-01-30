import java.util.Scanner;

public class WeddingPresents {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double numberOfGuests = Double.parseDouble(scanner.nextLine());
        double numberOfPresents = Double.parseDouble(scanner.nextLine());

        double moneyPresentsCounter = 0;
        double electricPresentsCounter = 0;
        double voucherPresentsCounter = 0;
        double otherPresentsCounter = 0;

        double peopleWithPresents = numberOfPresents / numberOfGuests;
        peopleWithPresents *= 100;

        for (int i = 0; i < numberOfPresents; i++) {
            String presentType = scanner.nextLine();

            if (presentType.equals("A")) {
                moneyPresentsCounter++;
            } else if (presentType.equals("B")) {
                electricPresentsCounter++;
            } else if (presentType.equals("V")) {
                voucherPresentsCounter++;
            } else if (presentType.equals("G")) {
                otherPresentsCounter++;
            }

        }

        System.out.printf("%.2f%%%n",(moneyPresentsCounter / numberOfPresents) * 100);
        System.out.printf("%.2f%%%n",(electricPresentsCounter / numberOfPresents) * 100);
        System.out.printf("%.2f%%%n",(voucherPresentsCounter / numberOfPresents) * 100);
        System.out.printf("%.2f%%%n",(otherPresentsCounter / numberOfPresents) * 100);
        System.out.printf("%.2f%%",peopleWithPresents);

    }
}
