import java.util.Scanner;

public class GroupStage {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String team = scanner.nextLine();
        int numberOfGames = Integer.parseInt(scanner.nextLine());

        int totalGoalsScored = 0;
        int totalGoalsReceived = 0;

        int points = 0;

        while (numberOfGames > 0) {

            int goalsScored = Integer.parseInt(scanner.nextLine());

            totalGoalsScored += goalsScored;

            int goalsReceived = Integer.parseInt(scanner.nextLine());

            totalGoalsReceived += goalsReceived;

            if (goalsScored > goalsReceived) {
                points += 3;
            } else if(goalsScored == goalsReceived){
                points += 1;
            }

            numberOfGames--;
        }

        int goalDifference = totalGoalsScored - totalGoalsReceived;

        if (totalGoalsScored >= totalGoalsReceived) {
            System.out.printf("%s has finished the group phase with %d points.%n", team, points);
            System.out.printf("Goal difference: %d.",goalDifference);
        } else {
            System.out.printf("%s has been eliminated from the group phase.%n",team);
            System.out.printf("Goal difference: %d.",goalDifference);
        }

    }

}
