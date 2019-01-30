import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder result = new StringBuilder();

        char prevSymbol = input.charAt(0);
        result.append(prevSymbol);

        for (int i = 1; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (prevSymbol != symbol) {
                prevSymbol =symbol;
                result.append(prevSymbol);
            }
        }

        System.out.println(result);

    }
}
