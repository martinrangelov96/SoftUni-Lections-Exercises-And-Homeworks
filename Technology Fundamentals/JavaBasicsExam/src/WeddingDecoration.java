import java.util.Scanner;

public class WeddingDecoration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balloonsPrice = 0.1;
        int balloonsCounter = 0;
        double flowersPrice = 1.5;
        int flowersCounter = 0;
        double candlesPrice = 0.5;
        int candlesCounter = 0;
        double ribbonPrice = 2.0;
        int ribbonCounter =0;

        double budget = Double.parseDouble(scanner.nextLine());
        String productType = scanner.nextLine();

        double sum = 0;

        while (!productType.equals("stop")) {
            int numberOfProducts = Integer.parseInt(scanner.nextLine());

            if (productType.equals("balloons")) {
                balloonsPrice *= numberOfProducts;
                sum += balloonsPrice;
                balloonsCounter+=numberOfProducts;
                balloonsPrice = 0.1;
            } else if (productType.equals("flowers")) {
                flowersPrice *= numberOfProducts;
                sum += flowersPrice;
                flowersCounter+=numberOfProducts;
                flowersPrice = 1.5;
            } else if (productType.equals("candles")) {
                candlesPrice *= numberOfProducts;
                sum += candlesPrice;
                candlesCounter+=numberOfProducts;
                candlesPrice = 0.5;
            } else if (productType.equals("ribbon")) {
                ribbonPrice *= numberOfProducts;
                sum += ribbonPrice;
                ribbonCounter+=numberOfProducts;
                ribbonPrice = 2.0;
            }

            if (sum >= budget) {
                System.out.println("All money is spent!");
                System.out.printf("Purchased decoration is %d balloons, %d m ribbon, %d flowers and %d candles.",
                        balloonsCounter,ribbonCounter,flowersCounter,candlesCounter);
                return;
            }

            productType = scanner.nextLine();
        }

        System.out.printf("Spend money: %.2f%n",sum);
        System.out.printf("Money left: %.2f%n",budget-sum);
        System.out.printf("Purchased decoration is %d balloons, %d m ribbon, %d flowers and %d candles.",
                balloonsCounter,ribbonCounter,flowersCounter,candlesCounter);

    }
}
