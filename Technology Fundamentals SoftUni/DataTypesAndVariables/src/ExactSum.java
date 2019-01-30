import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        BigDecimal bigDecimal;
        BigDecimal bigDecimalSum = new BigDecimal(0);

        for (int i = 0; i < n; i++) {
            bigDecimal = scanner.nextBigDecimal();
            bigDecimalSum = bigDecimalSum.add(bigDecimal);
        }

        System.out.println(bigDecimalSum);

    }
}
