import java.util.Scanner;

public class Logicstics {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfLoad = Integer.parseInt(scanner.nextLine());
        int tonsSum = 0;
        double microBusTons = 0.0;
        double truckTons = 0.0;
        double trainTons = 0.0;

        for (int i = 0; i < numberOfLoad; i++) {
            int tons = Integer.parseInt(scanner.nextLine());

            tonsSum += tons;

            if (tons <= 3) {
                microBusTons += tons;
            } else if (tons >= 4 && tons <= 11) {
                truckTons +=tons;
            } else if (tons > 11) {
                trainTons += tons;
            }
        }

        System.out.printf("%.2f%n",(microBusTons * 200 + truckTons * 175 + trainTons * 120) / tonsSum);
        System.out.printf("%.2f%%%n",microBusTons/tonsSum * 100);
        System.out.printf("%.2f%%%n",truckTons/tonsSum * 100);
        System.out.printf("%.2f%%%n",trainTons/tonsSum * 100);

    }

}
