import java.util.Scanner;

public class ToyShop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double puzzlePrice = 2.60;
        double talkingDoll = 3.00;
        double teddyBearPrice = 4.10;
        double minionPrice = 8.20;
        double truckPrice = 2.00;

        double vacationPrice = Double.parseDouble(scanner.nextLine());

        int numberOfPuzzles = Integer.parseInt(scanner.nextLine());
        int numberOfTalkingDolls = Integer.parseInt(scanner.nextLine());
        int numberOfTeddyBears = Integer.parseInt(scanner.nextLine());
        int numberOfMinions = Integer.parseInt(scanner.nextLine());
        int numberOfTrucks = Integer.parseInt(scanner.nextLine());

        double finalBillNoRent = (numberOfPuzzles * puzzlePrice) + (numberOfTalkingDolls * talkingDoll) +
                (numberOfTeddyBears * teddyBearPrice) + (numberOfMinions * minionPrice) + (numberOfTrucks * truckPrice);

        int numberOfItems = numberOfPuzzles + numberOfTalkingDolls + numberOfTeddyBears +
                numberOfMinions + numberOfTrucks;

        double shopDiscount = 0.25;
        double rent = 0.10;

        if (numberOfItems >= 50) {
            finalBillNoRent = finalBillNoRent - (shopDiscount * finalBillNoRent);
        }

        double finalBillWithRent = finalBillNoRent - (rent * finalBillNoRent);
        double moneyLeft = Math.abs(finalBillWithRent - vacationPrice);

        if (finalBillWithRent >= vacationPrice) {
            System.out.printf("Yes! %.2f lv left.", moneyLeft);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", moneyLeft);
        }

    }

}
