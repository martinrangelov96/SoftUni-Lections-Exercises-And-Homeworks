import java.util.Scanner;

public class ThreeBrothers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double firstBrotherTime = Double.parseDouble(scanner.nextLine());
        double secondBrother = Double.parseDouble(scanner.nextLine());
        double thirdBrotherTime = Double.parseDouble(scanner.nextLine());

        double dadFishingTime = Double.parseDouble(scanner.nextLine());

        double rest = 0.15;

        double cleaningTogetherTime = 1/(1/firstBrotherTime + 1/secondBrother + 1/thirdBrotherTime);
        double cleaningTogetherTimeWithRest = cleaningTogetherTime + (cleaningTogetherTime * rest);

        double timeLeft = dadFishingTime - cleaningTogetherTimeWithRest;

        System.out.printf("Cleaning time: %.2f%n", cleaningTogetherTimeWithRest);

        if (timeLeft > 0) {
            System.out.printf("Yes, there is a surprise - time left -> %.0f hours.", Math.floor(timeLeft));
        } else {
            timeLeft = Math.abs(timeLeft);
            System.out.printf("No, there isn't a surprise - shortage of time -> %.0f hours.", Math.ceil(timeLeft));
        }

    }

}
