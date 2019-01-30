import java.util.Scanner;

public class CharityCampaign {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int chefs = Integer.parseInt(scanner.nextLine());
        int cakes = Integer.parseInt(scanner.nextLine());
        int wafers = Integer.parseInt(scanner.nextLine());
        int pancakes = Integer.parseInt(scanner.nextLine());

        double cakesPrice = 45;
        double wafersPrice = 5.80;
        double pancakesPrice = 3.20;

        double money = (days * chefs) * ((cakes * cakesPrice) + (wafers * wafersPrice) + (pancakes * pancakesPrice));
        double finalCharityMoney = money - (money*1/8);

        System.out.println(String.format("%.2f", finalCharityMoney));

    }

}
