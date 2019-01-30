import java.util.Scanner;

public class ChallengeTheWedding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfMen = Integer.parseInt(scanner.nextLine());
        int numberOfWomen = Integer.parseInt(scanner.nextLine());
        int maxNumberOfTables = Integer.parseInt(scanner.nextLine());

        int tablesCounter = 0;

        for (int i = 1; i <= numberOfMen; i++) {
            for (int j = 1; j <= numberOfWomen; j++) {
                System.out.printf("(%d <-> %d) ", i, j);
                tablesCounter++;
                if (tablesCounter == maxNumberOfTables) {
                    return;
                }
            }
        }

    }
}
