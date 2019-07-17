import java.util.Scanner;

public class AlcoholMarket {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double whiskeyPrice = Double.parseDouble(scanner.nextLine());
        double beerQuantity = Double.parseDouble(scanner.nextLine());
        double wineQuantity = Double.parseDouble(scanner.nextLine());
        double rakiaQuantity = Double.parseDouble(scanner.nextLine());
        double whiskeyQuantity = Double.parseDouble(scanner.nextLine());

        double rakiaPrice = whiskeyPrice / 2;
        double winePrice = rakiaPrice - (0.4*rakiaPrice);
        double beerPrice = rakiaPrice - (0.8*rakiaPrice);

        double bill = ((whiskeyQuantity * whiskeyPrice) + (beerQuantity * beerPrice)
                + (rakiaQuantity * rakiaPrice) + (wineQuantity * winePrice));

        System.out.println(String.format("%.2f", bill));

    }

}
