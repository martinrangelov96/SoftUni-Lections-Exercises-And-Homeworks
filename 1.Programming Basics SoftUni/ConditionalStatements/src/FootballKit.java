import java.util.Scanner;

public class FootballKit {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double tShirtPrice = Double.parseDouble(scanner.nextLine());
        double priceForABonus = Double.parseDouble(scanner.nextLine());

        double shortsPrice = tShirtPrice * 0.75;
        double socksPrice = shortsPrice * 0.20;
        double bootsPrice = 2 * (tShirtPrice + shortsPrice);

        double finalBillNoDiscount = tShirtPrice + shortsPrice + socksPrice + bootsPrice;
        double discount = 0.15;

        double finalBillWithDiscount = finalBillNoDiscount - (finalBillNoDiscount*discount);

        if (finalBillWithDiscount >= priceForABonus) {
            System.out.println("Yes, he will earn the world-cup replica ball!");
            System.out.printf("His sum is %.2f lv.", finalBillWithDiscount);
        } else {
            double lackOfMoney = priceForABonus - finalBillWithDiscount;
            System.out.println("No, he will not earn the world-cup replica ball.");
            System.out.printf("He needs %.2f lv. more.", lackOfMoney);
        }


    }

}
