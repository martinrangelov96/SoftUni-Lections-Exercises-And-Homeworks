import java.util.Scanner;

public class FootballSouvenirs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();
        String souvenir = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        double itemPrice = 0.0;

        switch (country) {
            case "Argentina":
                switch (souvenir) {
                    case "flags":
                        itemPrice = 3.25;
                        break;
                    case "caps":
                        itemPrice = 7.20;
                        break;
                    case "posters":
                        itemPrice = 5.10;
                        break;
                    case "stickers":
                        itemPrice = 1.25;
                        break;
                    default:
                        System.out.println("Invalid stock!");
                        return;
                }
                break;
            case "Brazil":
                switch (souvenir) {
                    case "flags":
                        itemPrice = 4.20;
                        break;
                    case "caps":
                        itemPrice = 8.50;
                        break;
                    case "posters":
                        itemPrice = 5.35;
                        break;
                    case "stickers":
                        itemPrice = 1.20;
                        break;
                    default:
                        System.out.println("Invalid stock!");
                        return;
                }
                break;
            case "Croatia":
                switch (souvenir) {
                    case "flags":
                        itemPrice = 2.75;
                        break;
                    case "caps":
                        itemPrice = 6.90;
                        break;
                    case "posters":
                        itemPrice = 4.95;
                        break;
                    case "stickers":
                        itemPrice = 1.10;
                        break;
                    default:
                        System.out.println("Invalid stock!");
                        return;
                }
                break;
            case "Denmark":
                switch (souvenir) {
                    case "flags":
                        itemPrice = 3.10;
                        break;
                    case "caps":
                        itemPrice = 6.50;
                        break;
                    case "posters":
                        itemPrice = 4.80;
                        break;
                    case "stickers":
                        itemPrice = 0.90;
                        break;
                    default:
                        System.out.println("Invalid stock!");
                        return;
                }
                break;
            default:
                System.out.println("Invalid country!");
                return;
        }

        double totalPrice = itemPrice * quantity;

        System.out.printf("Pepi bought %d %s of %s for %.2f lv. ", quantity, souvenir, country, totalPrice);

    }

}