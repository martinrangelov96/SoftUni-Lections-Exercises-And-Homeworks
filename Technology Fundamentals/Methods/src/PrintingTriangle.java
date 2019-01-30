import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        printTriangle(number);

    }

    public static void printLine(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    public static void printTriangle(int n) {
        for (int i = 0; i <= n; i++) {
            printLine(1, i);
        }

        for (int i = n - 1; i > 0; i--) {
            printLine(1, i);
        }
    }

}
