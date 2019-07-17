import java.util.Scanner;

public class GameInfo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String teamName = scanner.nextLine();
        int numberOfGames = Integer.parseInt(scanner.nextLine());

        int gameMinutesTotal = 0;
        int gamesWithAdditionalTime = 0;
        int gamesWithPenalties = 0;

        for (int i = 0; i < numberOfGames; i++) {
            int gameMinutes = Integer.parseInt(scanner.nextLine());

            gameMinutesTotal += gameMinutes;

            if (gameMinutes > 90 && gameMinutes <= 120) {
                gamesWithAdditionalTime++;
            } else if (gameMinutes > 120) {
                gamesWithPenalties++;
            }
        }

        double gameMinutesAverage = gameMinutesTotal *1.0 / numberOfGames;

        System.out.printf("%s has played %d minutes. ",teamName,gameMinutesTotal);
        System.out.printf("Average minutes per game: %.2f%n", gameMinutesAverage);
        System.out.printf("Games with penalties: %d%n", gamesWithPenalties);
        System.out.printf("Games with additional time: %d%n",gamesWithAdditionalTime);

    }

}
