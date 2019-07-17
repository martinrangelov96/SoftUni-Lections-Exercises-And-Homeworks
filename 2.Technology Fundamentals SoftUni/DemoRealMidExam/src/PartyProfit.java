import java.util.Scanner;

public class PartyProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int partySize = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        double coins = 0.0;

        for (int i = 1; i <= days; i++) {

            if (i % 10 == 0) {
                partySize -= 2;
            }
            if (i % 15 == 0) {
                partySize += 5;
            }

            //food
            coins += 50;
            coins -= 2 * partySize;

            if (i % 3 == 0) {
                //water
                coins -= 3 * partySize;
            }
            if (i % 5 == 0) {
                coins += 20 * partySize;
                if (i % 3 == 0) {
                    coins -= 2 * partySize;
                }
            }
        }

        System.out.printf("%d companions received %d coins each.", partySize, (int)coins/ partySize);

    }
}
