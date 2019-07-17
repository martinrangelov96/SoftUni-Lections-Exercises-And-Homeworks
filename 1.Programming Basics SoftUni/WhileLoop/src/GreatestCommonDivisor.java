import java.util.Scanner;

public class GreatestCommonDivisor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        while (b != 0) {

            int newB = b;
            b = a % b;
            a = newB;

        }

        System.out.println(a);

    }

}
