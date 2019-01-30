import java.util.Scanner;

public class Walking {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int sumSteps = 0;

        while (true) {
            if (input.equals("Going home")) {
                int goingHomeSteps = Integer.parseInt(scanner.nextLine());
                sumSteps += goingHomeSteps;
                break;
            }
            int steps = Integer.parseInt(input);
            sumSteps += steps;
            if (sumSteps >= 10000) {
                break;
            }
            input = scanner.nextLine();
        }

        if (sumSteps < 10000) {
            System.out.printf("%d more steps to reach goal.", 10000 - sumSteps);
        } else {
            System.out.println("Goal reached! Good job!");
        }

    }

}
