import java.util.Scanner;

public class TransportPrice {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfKilometers = Integer.parseInt(scanner.nextLine());
        String dayOrNight = scanner.nextLine();

        double taxiRate = 0.0;

        double bus = 0.09 * numberOfKilometers;

        double train = 0.06 * numberOfKilometers;

        double price;

        if (dayOrNight.equals("day")) {
            taxiRate = 0.70 + (0.79 * numberOfKilometers);
        } else if(dayOrNight.equals("night")) {
            taxiRate = 0.70 + (0.90 * numberOfKilometers);
        }

        if (numberOfKilometers < 20) {
            price = taxiRate;
        } else if (numberOfKilometers >= 20 && numberOfKilometers < 100) {
            price = bus;
        } else {
            price = train;
        }

        System.out.println(price);
    }

}
