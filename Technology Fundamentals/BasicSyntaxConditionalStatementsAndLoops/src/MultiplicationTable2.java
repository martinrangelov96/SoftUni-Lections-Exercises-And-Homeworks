import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int multuplier = Integer.parseInt(scanner.nextLine());

        if (multuplier > 10) {
            System.out.printf("%d X %d = %d", number, multuplier, number * multuplier);
        }

        for (;multuplier <= 10; multuplier++) {
            System.out.printf("%d X %d = %d%n", number, multuplier, number * multuplier);
        }


    }
}
