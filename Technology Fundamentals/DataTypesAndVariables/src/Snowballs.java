import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSnowballs = Integer.parseInt(scanner.nextLine());

        int snowballSnow = 0;
        int snowballTime = 0;
        int snowballQuality = 0;
        int winnerSnowballSnow = 0;
        int winnerSnowballTime = 0;
        int winnerSnowballQuality = 0;

        double snowballValue = 0;
        double bestSnowball = -Double.MIN_VALUE;

        for (int i = 0; i < numberOfSnowballs; i++) {
            snowballSnow = Integer.parseInt(scanner.nextLine());
            snowballTime = Integer.parseInt(scanner.nextLine());
            snowballQuality = Integer.parseInt(scanner.nextLine());
            snowballValue = Math.pow((snowballSnow *1.0 / snowballTime),snowballQuality);

            if (snowballValue > bestSnowball) {
                bestSnowball = snowballValue;
                winnerSnowballSnow = snowballSnow;
                winnerSnowballTime = snowballTime;
                winnerSnowballQuality = snowballQuality;
            }
        }

        System.out.printf("%d : %d = %.0f (%d)",
                winnerSnowballSnow,winnerSnowballTime,bestSnowball,winnerSnowballQuality);

    }
}
