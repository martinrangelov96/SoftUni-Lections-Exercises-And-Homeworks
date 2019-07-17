import java.util.Scanner;

public class BestPlayer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int mostGoalsScored = Integer.MIN_VALUE;

        String playerWithMostGoals = "";
        String playerName = scanner.nextLine();

        while (true) {

            if (playerName.equals("END")) {
                System.out.printf("%s is the best player!%n", playerWithMostGoals);
                if (mostGoalsScored >= 3) {
                    System.out.printf("He has scored %d goals and made a hat-trick !!!", mostGoalsScored);
                } else {
                    System.out.printf("He has scored %d goals.", mostGoalsScored);
                }
                break;
            }

            int goalsScored = Integer.parseInt(scanner.nextLine());

            if (goalsScored > mostGoalsScored) {
                mostGoalsScored = goalsScored;
                playerWithMostGoals = playerName;
            }

            if (goalsScored >= 10) {
                System.out.printf("%s is the best player!%n", playerName);
                System.out.printf("He has scored %d goals and made a hat-trick !!!", mostGoalsScored);
                break;
            }

            playerName = scanner.nextLine();

        }

    }

}
