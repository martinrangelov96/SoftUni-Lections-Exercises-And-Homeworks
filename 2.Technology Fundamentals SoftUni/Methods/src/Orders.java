import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String order = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        calculateOrder(order,quantity);

    }

    public static void calculateOrder(String order, int quantity) {
        double price = 0.0;
        switch (order) {
            case "coffee":
                price = 1.50 * quantity;
                System.out.printf("%.2f",price);
                break;
            case "water":
                price = 1.00 * quantity;
                System.out.printf("%.2f",price);
                break;
            case "coke":
                price = 1.40 * quantity;
                System.out.printf("%.2f",price);
                break;
            case "snacks":
                price = 2.00 * quantity;
                System.out.printf("%.2f",price);
                break;
            default:
                System.out.println("Wrong values kys");
                break;
        }
    }

}
