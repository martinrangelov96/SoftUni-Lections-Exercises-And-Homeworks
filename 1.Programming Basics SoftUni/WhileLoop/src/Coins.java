import java.util.Scanner;

public class Coins {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double change = Double.parseDouble(scanner.nextLine());
        change = change * 100;
        int numberOfCoins = 0;

        while(change >= 1) {

            if ((change - 200) >= 0) {
                change -=200;
                numberOfCoins++;
            } else if ((change - 100) >= 0) {
                change -=100;
                numberOfCoins++;
            } else if ((change - 50) >=0) {
                change -= 50;
                numberOfCoins++;
            } else if ((change - 20) >= 0) {
                change -= 20;
                numberOfCoins++;
            } else if ((change - 10) >= 0) {
                change-=10;
                numberOfCoins++;
            } else if((change - 5) >= 0) {
                change-=5;
                numberOfCoins++;
            } else if((change - 2) >= 0) {
                change -=2;
                numberOfCoins++;
            } else if((change - 1 ) >= 0) {
                change -=1;
                numberOfCoins++;
            }

        }

        System.out.println(numberOfCoins);

    }

}
