import java.util.Scanner;

public class GameOfNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPlayers = Integer.parseInt(scanner.nextLine());
        int initialScore = 0;
        int biggestScore = Integer.MIN_VALUE;
        String winner = "";

        for (int i = 0; i < numberOfPlayers; i++) {
            String name = scanner.nextLine();
            initialScore = Integer.parseInt(scanner.nextLine());

            for (int j = 0; j < name.length(); j++) {
                if (name.charAt(j) % 2 == 0) {
                    initialScore += name.charAt(j);
                } else {
                    initialScore -= name.charAt(j);
                }
            }

            if (initialScore > biggestScore) {
                winner = name;
                biggestScore = initialScore;
            }
        }

        System.out.printf("The winner is %s - %d points", winner, biggestScore);

    }
}
