import java.util.Scanner;

public class PipesInPool {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int volume = Integer.parseInt(scanner.nextLine());
        int pipe1 = Integer.parseInt(scanner.nextLine());
        int pipe2 = Integer.parseInt(scanner.nextLine());
        double hours = Double.parseDouble(scanner.nextLine());

        double water = pipe1 * hours + pipe2 * hours;

        if (water <= volume) {
            double fullPercent = Math.floor((water / volume) * 100.0);
            double pipe1Percent = Math.floor((pipe1 * hours) / water * 100.0);
            double pipe2Percent = Math.floor((pipe2 * hours) / water * 100.0);
            System.out.printf("The pool is %.0f%% full. Pipe 1: %.0f%%. Pipe 2: %.0f%%.", fullPercent, pipe1Percent, pipe2Percent);
        } else {
            double overflow = water - volume;
            System.out.printf("For %.1f hours the pool overflows with %.0f liters.", hours, overflow);
        }

    }

}
