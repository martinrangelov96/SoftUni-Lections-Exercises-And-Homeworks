import java.util.Scanner;

public class HitTheTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int targetNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i < 21 ; i++) {
            for (int j = 1; j < 21 ; j++) {
                if (i + j == targetNumber) {
                    System.out.printf("%d + %d = %d%n",i, j, targetNumber);
                } else if (i - j == targetNumber) {
                    System.out.printf("%d - %d = %d%n",i, j, targetNumber);
                }
            }
        }

    }
}
