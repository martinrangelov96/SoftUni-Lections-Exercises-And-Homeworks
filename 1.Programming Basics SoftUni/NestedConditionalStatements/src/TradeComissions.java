import java.util.Scanner;

public class TradeComissions {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        double sales = Double.parseDouble(scanner.nextLine());
        double price = 0.0;

        if (town.equals("Sofia")) {
            if (0 <= sales && sales <= 500) {
                price = sales * 0.05;
            } else if (500 < sales && sales <= 1000) {
                price = sales * 0.07;
            } else if (1000 < sales && sales <= 10000) {
                price = sales * 0.08;
            } else if (sales > 10000) {
                price = sales * 0.12;
            } else {
                System.out.println("error");
            }
        } else if (town.equals("Varna")) {
            if (0 <= sales && sales <= 500) {
                price = sales * 0.045;
            } else if (500 < sales && sales <= 1000) {
                price = sales * 0.075;
            } else if (1000 < sales && sales <= 10000) {
                price = sales * 0.10;
            } else if (sales > 10000) {
                price = sales * 0.13;
            } else {
                System.out.println("error");
            }
        } else if (town.equals("Plovdiv")) {
            if (0 <= sales && sales <= 500) {
                price = sales * 0.055;
            } else if (500 < sales && sales <= 1000) {
                price = sales * 0.08;
            } else if (1000 < sales && sales <= 10000) {
                price = sales * 0.12;
            } else if (sales > 10000) {
                price = sales * 0.145;
            } else {
                System.out.println("error");
            }
        } else {
            System.out.println("error");
        }

        if (sales > 0) {
            System.out.println(price);
        }
    }

}
