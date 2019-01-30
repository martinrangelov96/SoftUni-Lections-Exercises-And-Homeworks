import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int linesCount = Integer.parseInt(scanner.nextLine());

        int[] first = new int[linesCount];
        int[] second = new int[linesCount];

        for (int i = 0; i < linesCount ; i++) {
            String[] numbers = scanner.nextLine().split(" ");
            if (i % 2 == 0) {
                first[i] = Integer.parseInt(numbers[0]);
                second[i] = Integer.parseInt(numbers[1]);
            } else {
                first[i] = Integer.parseInt(numbers[1]);
                second[i] = Integer.parseInt(numbers[0]);
            }
        }

        for (int number : first) {
            System.out.print(number + " ");
        }
        System.out.println();
        for (int number : second) {
            System.out.print(number + " ");
        }

    }
}
