import java.util.Scanner;

public class StudentsResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //padding -> String value = String.format("%1$-10s || %2$10s", 1.26, 5.55);

        String[] input = scanner.nextLine().split("[,\\s-]+");

        double avg = 0;

        for (int i = 1; i < input.length; i++) {
            avg += Double.parseDouble(input[i]);
            if (i == input.length - 1) {
                avg /= 3;
            }
        }

        System.out.printf("%-10s|%7s|%7s|%7s|%7s|%n", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");
        System.out.printf("%-10s|%7.2f|%7.2f|%7.2f|%7.4f|%n", input[0], Double.valueOf(input[1]), Double.valueOf(input[2]), Double.valueOf(input[3]), avg);

    }
}
