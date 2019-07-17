import java.util.Scanner;

public class NumberSequence {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        while (!input.equals("END")) {
            int num = Integer.parseInt(input);

            if (num > maxNum) {
                maxNum = num;
            }

            if (num < minNum) {
                minNum = num;
            }

            input = scanner.nextLine();
        }

        System.out.printf("Max number: %d%n", maxNum);
        System.out.printf("Min number: %d", minNum);

    }

}
