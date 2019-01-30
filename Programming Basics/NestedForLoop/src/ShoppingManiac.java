import java.util.Scanner;

public class ShoppingManiac {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int maxMoney = Integer.parseInt(scanner.nextLine());
        int money = 0;
        int moneySum = 0;
        int clothesCounter = 0;

        String input = "";

        while (true) {

            input = scanner.nextLine();

            if (input.equals("enter")) {
                while (true) {
                    input = scanner.nextLine();
                    if (input.equals("leave")) {
                        break;
                    }
                    money = Integer.parseInt(input);
                    moneySum += money;
                    clothesCounter++;
                    if (moneySum == maxMoney) {
                        System.out.printf("For %d clothes I spent %d lv and have %d lv left.",clothesCounter, moneySum, moneySum - maxMoney);
                        return;
                    }
                    if (moneySum > maxMoney) {
                        System.out.println("Not enough money.");
                        moneySum -= money;
                        clothesCounter--;
                    }
                }
            }

            if (input.equals("enough")) {
                break;
            }

        }

        System.out.printf("For %d clothes I spent %d lv and have %d lv left.%n",clothesCounter, moneySum, maxMoney - moneySum);

    }

}
