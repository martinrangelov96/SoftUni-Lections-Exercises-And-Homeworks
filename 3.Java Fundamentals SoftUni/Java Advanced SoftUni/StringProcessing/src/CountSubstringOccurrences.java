import java.util.Scanner;

public class CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();

        String countAppearances = scanner.nextLine();

        int count = 0;

        for (int i = 0; i < input.length() - countAppearances.length(); i++) {
            if (input.substring(i, countAppearances.length() + i).equals(countAppearances)) {
                count++;
            }
        }

        System.out.println(count);

    }
}
