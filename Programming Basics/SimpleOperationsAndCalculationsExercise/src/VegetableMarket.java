import java.util.Scanner;

public class VegetableMarket {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double vegetablesPriceForOneKg = Double.parseDouble(scanner.nextLine());
        double fruitsPriceForOneKg = Double.parseDouble(scanner.nextLine());
        double vegetableKilograms = Double.parseDouble(scanner.nextLine());
        double fruitsKilograms = Double.parseDouble(scanner.nextLine());

        double moneyInLeva = (vegetableKilograms * vegetablesPriceForOneKg) + (fruitsKilograms * fruitsPriceForOneKg);
        double moneyInEuro = moneyInLeva / 1.94;

        System.out.println(moneyInEuro);
    }

}
