import java.util.Scanner;

public class Cake {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int cakeParts = width * length;

        int cakesTakenSum = 0;

        String input = scanner.nextLine();

        while (true) {
            if (input.equals("STOP")) {
                int cakeLeft = cakeParts - cakesTakenSum;
                System.out.printf("%d pieces are left.", cakeLeft);
                break;
            }

            int cakesTaken = Integer.parseInt(input);
            cakesTakenSum += cakesTaken;

            if (cakesTakenSum > cakeParts) {
                int cakeNeeded = cakesTakenSum - cakeParts;
                System.out.printf("No more cake left! You need %d pieces more.", cakeNeeded);
                break;
            }

            input = scanner.nextLine();
        }

    }

}
