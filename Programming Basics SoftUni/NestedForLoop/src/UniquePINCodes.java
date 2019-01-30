import java.util.Scanner;

public class UniquePINCodes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= num1; i++) {
            for (int j = 2; j <= num2; j++) {
                for (int k = 1; k <= num3; k++) {
                    if (i % 2 == 0 & k % 2 == 0) {
                        if (j == 2 || j == 3 || j == 5 || j == 7) {
                            System.out.println(i + " " + j + " " + k);
                        }
                    }
                }
            }
        }

    }

}
