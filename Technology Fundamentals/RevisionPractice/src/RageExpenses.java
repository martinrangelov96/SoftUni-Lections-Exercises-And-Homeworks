import java.util.Scanner;

public class RageExpenses {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int games = Integer.parseInt(scanner.nextLine());
        double headSetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int headSetCount = games / 2;
        int mouseCount = games / 3;
        int keyboardCount = games / 6;
        int displayCount = games / 12;

        double cost = headSetCount * headSetPrice + mouseCount * mousePrice + keyboardCount * keyboardPrice +
                displayCount * displayPrice;

        System.out.println(String.format("Rage expenses: %.2f lv.",cost));

    }

}
