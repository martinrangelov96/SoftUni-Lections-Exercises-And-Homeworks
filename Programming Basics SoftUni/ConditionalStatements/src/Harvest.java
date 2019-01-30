import java.util.Scanner;

public class Harvest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int vineyardArea = Integer.parseInt(scanner.nextLine());
        double grapePerSquare = Double.parseDouble(scanner.nextLine());
        int neededLiters = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());

        double totalGrapes = (vineyardArea * grapePerSquare) * 0.40;
        double wine = totalGrapes / 2.5;

        if (wine >= neededLiters) {
            double litersLeft = wine - neededLiters;
            double litersForAWorker = litersLeft / workers;
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n"
                    ,Math.floor(wine));
            System.out.printf("%.0f liters left -> %.0f liters per person.",
                    Math.ceil(litersLeft), Math.ceil(litersForAWorker));
        } else {
            double litersNeeded = neededLiters - wine;
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(litersNeeded));
        }


    }

}
