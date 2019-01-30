import java.util.Scanner;

public class CurrencyConvertor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Money value: ");
        double moneyValue = Double.parseDouble(scanner.nextLine());

        System.out.print("From currency (BGN/USD/EUR/BGP): ");
        String fromCurrency = scanner.nextLine();
        System.out.print("To currency (BGN/USD/EUR/BGP): ");
        String toCurrency = scanner.nextLine();

        switch (fromCurrency) {
            case "USD":
                moneyValue = (moneyValue * 1.79549);
                break;
            case "EUR":
                moneyValue = (moneyValue * 1.95583);
                break;
            case "GBP":
                moneyValue = (moneyValue * 2.53405);
                break;
            case "BGN":
                moneyValue = (moneyValue * 1);
                break;
            default:
                System.out.println("Wrong currency!");
                return;
        }

        switch (toCurrency) {
            case "USD":
                moneyValue = (moneyValue / 1.79549);
                break;
            case "EUR":
                moneyValue = (moneyValue / 1.95583);
                break;
            case "GBP":
                moneyValue = (moneyValue / 2.53405);
                break;
            case "BGN":
                moneyValue = (moneyValue / 1);
                break;
            default:
                System.out.println("Wrong currency!");
                return;
        }

        System.out.println(String.format("%.2f", moneyValue) + " " +toCurrency);

    }

}
