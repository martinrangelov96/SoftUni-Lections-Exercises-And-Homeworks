import java.util.Scanner;

public class MaxNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int maxNumber = Integer.MIN_VALUE;

        for (int y = 0; y < n; y++) {
            int num = Integer.parseInt(scanner.nextLine());
            if (num > maxNumber) {
                maxNumber = num;
            }
        }

        System.out.println(maxNumber);

    }

}
