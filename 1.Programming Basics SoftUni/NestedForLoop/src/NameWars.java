import java.util.Scanner;

public class NameWars {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String winner = "";
        int score = 0;

        while (!name.equals("STOP")) {

            int tempScore = 0;
            for (int i = 0; i < name.length(); i++) {
                tempScore += name.charAt(i);
            }
            if (tempScore > score) {
                score = tempScore;
                winner = name;
            }
            name = scanner.nextLine();
        }

        System.out.printf("Winner is %s - %d!",winner,score);

    }

}
