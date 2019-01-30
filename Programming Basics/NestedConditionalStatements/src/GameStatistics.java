import java.util.Scanner;

public class GameStatistics {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int minutes = Integer.parseInt(scanner.nextLine());
        String player = scanner.nextLine();

        if (minutes == 0) {
            System.out.println("Match has just began!");
        } else if (minutes < 45) {
            System.out.println("First half time.");
        } else if (minutes >= 45) {
            System.out.println("Second half time.");
        }

        if (1 <= minutes && minutes <= 10) {
            System.out.printf("%s missed a penalty.%n", player);
            if (minutes % 2 == 0) {
                System.out.printf("%s was injured after the penalty.", player);
            }
        } else if (10 < minutes && minutes <= 35) {
            System.out.printf("%s received yellow card.%n", player);
            if (minutes % 2 == 1) {
                System.out.printf("%s got another yellow card.", player);
            }
        } else if (35 < minutes && minutes < 45) {
            System.out.printf("%s SCORED A GOAL !!!", player);
        } else if (45 < minutes && minutes <= 55) {
            System.out.printf("%s got a freekick.%n", player);
            if (minutes % 2 == 0) {
                System.out.printf("%s missed the freekick.", player);
            }
        } else if (55 < minutes && minutes <= 80) {
            System.out.printf("%s missed a shot from corner.%n", player);
            if (minutes % 2 == 1) {
                System.out.printf("%s has been changed with another player.", player);
            }
        } else if (80 < minutes && minutes <= 90) {
            System.out.printf("%s SCORED A GOAL FROM PENALTY !!!", player);
        }

    }

}
