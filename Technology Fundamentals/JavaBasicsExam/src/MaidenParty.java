import java.util.Scanner;

public class MaidenParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double maidenPartyPrice = Double.parseDouble(scanner.nextLine());
        int numberOfLoveLetters = Integer.parseInt(scanner.nextLine());
        int numberOfWaxRoses = Integer.parseInt(scanner.nextLine());
        int numberOfKeyholders = Integer.parseInt(scanner.nextLine());
        int numberOfCaricatures= Integer.parseInt(scanner.nextLine());
        int numberOfSurprises= Integer.parseInt(scanner.nextLine());

        double loveLetterPrice = 0.60;
        double waxRosePrice = 7.20;
        double keyholderPrice = 3.60;
        double caricaturePrice = 18.20;
        double surprisePrice = 22.00;

        int numberOfArticules = numberOfLoveLetters+numberOfWaxRoses+numberOfKeyholders+numberOfCaricatures+numberOfSurprises;

        double herMoney = (numberOfLoveLetters * loveLetterPrice) + (numberOfWaxRoses * waxRosePrice) +
                (numberOfKeyholders * keyholderPrice) + (numberOfCaricatures * caricaturePrice) + (numberOfSurprises * surprisePrice);

        if (numberOfArticules >= 25) {
            herMoney *= 0.65;
        }

        herMoney *= 0.90;

        if (herMoney > maidenPartyPrice) {
            System.out.printf("Yes! %.2f lv left.",herMoney-maidenPartyPrice);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.",maidenPartyPrice-herMoney);
        }

    }
}
