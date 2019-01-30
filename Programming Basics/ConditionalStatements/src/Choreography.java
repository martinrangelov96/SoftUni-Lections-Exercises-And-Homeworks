import java.util.Scanner;

public class Choreography {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double numberOfSteps = Integer.parseInt(scanner.nextLine());
        double numberOfDancers = Integer.parseInt(scanner.nextLine());
        double daysToPractice = Integer.parseInt(scanner.nextLine());

        double stepsPerDayPercentage = Math.ceil((numberOfSteps/daysToPractice) / numberOfSteps * 100);
        double percentageOfStepsForEveryDancer = (stepsPerDayPercentage / numberOfDancers);

        if (stepsPerDayPercentage <= 13) {
            System.out.printf("Yes, they will succeed in that goal! %.2f%%.", percentageOfStepsForEveryDancer);
        } else {
            System.out.printf("No, They will not succeed in that goal! Required %.2f%% steps to be learned per day."
            ,percentageOfStepsForEveryDancer);
        }

    }

}
