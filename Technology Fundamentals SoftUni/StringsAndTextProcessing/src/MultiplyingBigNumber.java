import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiplyingBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();

        int multiplicator = Integer.parseInt(scanner.nextLine());

        if (multiplicator == 0) {
            System.out.println(0);
        } else {
            int reminder = 0;
            List<Integer> result = new ArrayList<>();
            for (int i = number.length() - 1; i >= 0; i--) {
                int currentResult = (number.charAt(i) - '0') * multiplicator;
                currentResult += reminder;
                reminder = currentResult / 10;
                result.add(currentResult % 10);
            }

            if (reminder != 0) {
                result.add(reminder);
            }

            for (int i = result.size() - 1; i >= 0 ; i--) {
                System.out.print(result.get(i));
            }
            System.out.println();
        }
    }
}
