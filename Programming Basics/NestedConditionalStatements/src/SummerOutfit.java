import java.util.Scanner;

public class SummerOutfit {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int degrees = Integer.parseInt(scanner.nextLine());
        String timeOfDay = scanner.nextLine();

        String outfit = "";
        String shoes = "";

        if (10 <= degrees && degrees <= 18) {
            if (timeOfDay.equals("Morning")){
                outfit = "Sweatshirt";
                shoes = "Sneakers";
            } else if(timeOfDay.equals("Afternoon")) {
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if(timeOfDay.equals("Evening")) {
                outfit = "Shirt";
                shoes = "Moccasins";
            }
        } else if (18 < degrees && degrees <= 24) {
            if (timeOfDay.equals("Morning")){
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if(timeOfDay.equals("Afternoon")) {
                outfit = "T-Shirt";
                shoes = "Sandals";
            } else if(timeOfDay.equals("Evening")) {
                outfit = "Shirt";
                shoes = "Moccasins";
            }
        } else if (degrees >= 25) {
            if (timeOfDay.equals("Morning")){
                outfit = "T-Shirt";
                shoes = "Sandals";
            } else if(timeOfDay.equals("Afternoon")) {
                outfit = "Swim Suit";
                shoes = "Barefoot";
            } else if(timeOfDay.equals("Evening")) {
                outfit = "Shirt";
                shoes = "Moccasins";
            }
        } else {
            System.out.println("Wrong");
        }

        System.out.printf("It's %d degrees, get your %s and %s.", degrees, outfit, shoes);

    }

}
