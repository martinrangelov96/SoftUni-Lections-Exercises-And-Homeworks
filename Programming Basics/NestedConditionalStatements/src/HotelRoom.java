import java.util.Scanner;

public class HotelRoom {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int numberOfOvernights = Integer.parseInt(scanner.nextLine());

        double studioPricePerNight = 0.0;
        double apartmentPricePerNight = 0.0;

        switch (month) {
            case "May":
            case "October":
                studioPricePerNight = 50.00;
                apartmentPricePerNight = 65.00;
                if (numberOfOvernights > 7 && numberOfOvernights < 14) {
                    studioPricePerNight = studioPricePerNight * 0.95;
                } else if (numberOfOvernights > 14) {
                    studioPricePerNight = studioPricePerNight * 0.70;
                    apartmentPricePerNight = apartmentPricePerNight * 0.90;
                }
                break;
            case "June":
            case "September":
                studioPricePerNight = 75.20;
                apartmentPricePerNight = 68.70;
                if (numberOfOvernights > 14) {
                    studioPricePerNight = studioPricePerNight * 0.80;
                    apartmentPricePerNight = apartmentPricePerNight * 0.90;
                }
                break;
            case "July":
            case "August":
                studioPricePerNight = 76.00;
                apartmentPricePerNight = 77.00;
                if (numberOfOvernights > 14) {
                    apartmentPricePerNight = apartmentPricePerNight * 0.90;
                }
                break;
            default:
                System.out.println("Wrong values");
        }

        double studioPriceForAllNights = studioPricePerNight * numberOfOvernights;
        double apartmentPriceForAllNights = apartmentPricePerNight * numberOfOvernights;

        System.out.printf("Apartment: %.2f lv.%n", apartmentPriceForAllNights);
        System.out.printf("Studio: %.2f lv.", studioPriceForAllNights);

    }

}
