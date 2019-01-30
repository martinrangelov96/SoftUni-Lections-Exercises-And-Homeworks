import java.security.SecureRandom;
import java.util.Scanner;

public class WeddingSeats {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char lastSector = scanner.nextLine().charAt(0);
        int rowNumber = Integer.parseInt(scanner.nextLine());
        int placeNumber = Integer.parseInt(scanner.nextLine());

        int n = 0;
        int i = 0;
        int placesCounter = 0;

        for (char ch = 'A'; ch <= lastSector; ch++) {
            for (i = 1; i <= rowNumber + n; i++) {
                if (i % 2 == 1) {
                    for (char j = 'a'; j <= (char) placeNumber + 96; j++) {
                        System.out.printf("%c%d%c%n", ch, i, j);
                        placesCounter++;
                    }
                } else {
                    for (char j = 'a'; j <= (char) placeNumber + 96 + 2; j++) {
                        System.out.printf("%c%d%c%n", ch, i, j);
                        placesCounter++;
                    }
                }
            }
            n++;
        }

        System.out.println(placesCounter);

    }
}
