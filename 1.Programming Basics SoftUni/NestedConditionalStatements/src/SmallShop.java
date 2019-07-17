import java.util.Scanner;

public class SmallShop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        String town = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        double price = 0.0;

        if (town.equals("Sofia")) {
            if (product.equals("coffee")) {
                    price = quantity * 0.5;
                } else if (product.equals("water")) {
                    price = quantity * 0.8;
                } else if (product.equals("beer")) {
                    price = quantity * 1.20;
                } else if (product.equals("sweets")) {
                    price = quantity * 1.45;
                } else if (product.equals("peanuts")) {
                    price = quantity * 1.60;
            }
        } else if (town.equals("Plovdiv")) {
            if (product.equals("coffee")) {
                price = quantity * 0.40;
            } else if (product.equals("water")) {
                price = quantity * 0.70;
            } else if (product.equals("beer")) {
                price = quantity * 1.15;
            } else if (product.equals("sweets")) {
                price = quantity * 1.30;
            } else if (product.equals("peanuts")) {
                price = quantity * 1.50;
            }
        } else if (town.equals("Varna")) {
            if (product.equals("coffee")) {
                price = quantity * 0.45;
            } else if (product.equals("water")) {
                price = quantity * 0.70;
            } else if (product.equals("beer")) {
                price = quantity * 1.10;
            } else if (product.equals("sweets")) {
                price = quantity * 1.35;
            } else if (product.equals("peanuts")) {
                price = quantity * 1.55;
            }
        }

        System.out.println(price);

    }

}
