import java.util.Scanner;

public class WedingTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double whiskeyPrice = Double.parseDouble(scanner.nextLine());

        double waterLiters = Double.parseDouble(scanner.nextLine());
        double wineLiters = Double.parseDouble(scanner.nextLine());
        double champaigneLiters = Double.parseDouble(scanner.nextLine());
        double whiskeyInLiters = Double.parseDouble(scanner.nextLine());

        double champaignePrice = whiskeyPrice * 0.50;
        double winePrice = champaignePrice * 0.40;
        double waterPrice = champaignePrice * 0.10;

        double sum = (whiskeyPrice * whiskeyInLiters) + (winePrice * wineLiters) + (champaignePrice * champaigneLiters) +
                (waterPrice * waterLiters);

        System.out.printf("%.2f",sum);

    }
}
