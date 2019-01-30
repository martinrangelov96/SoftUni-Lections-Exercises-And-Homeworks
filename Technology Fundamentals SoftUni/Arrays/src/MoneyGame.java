import java.util.Arrays;
import java.util.Scanner;

public class MoneyGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] money = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();


        int startPosition = Integer.parseInt(scanner.nextLine());
        double sum = money[startPosition];

        String direction = scanner.nextLine();

        while (!direction.equals("END")) {

            if (direction.equals("L")) {
                if (startPosition == 0) {
                    System.out.println("Cannot move left. Please move right.");
                } else
                    startPosition--;
                sum += money[startPosition];
            } else if (direction.equals("R")) {
                if (startPosition == money.length - 1) {
                    System.out.println("Cannot move right. Please move left.");
                } else
                    startPosition++;
                sum += money[startPosition];
            } else {
                System.out.println("Invalid direction.");
            }

            direction = scanner.nextLine();
        }

        System.out.println(sum);

    }
}
