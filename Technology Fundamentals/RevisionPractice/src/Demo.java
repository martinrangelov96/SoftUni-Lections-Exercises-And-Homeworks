import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numberAsString = scanner.nextLine();

        int number = Integer.parseInt(numberAsString);
        int sum = 0;

        for (int i = 0; i < numberAsString.length(); i++) {
            int digit = numberAsString.charAt(i) - '0';

            int factorial = 1;

            for (int j = 1; j <= digit; j++) {
                factorial *= j;
            }
            sum += factorial;

        }

        if (sum == number) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
