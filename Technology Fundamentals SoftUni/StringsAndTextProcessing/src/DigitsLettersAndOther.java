import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        for (int i = 0; i < input.length() ; i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                System.out.print(ch);
            }
        }

        System.out.println();

        for (int i = 0; i < input.length() ; i++) {
            char ch = input.charAt(i);
            if (Character.isLetter(ch)) {
                System.out.print(ch);
            }
        }

        System.out.println();

        for (int i = 0; i < input.length() ; i++) {
            char ch = input.charAt(i);
            if (!Character.isLetterOrDigit(ch)) {
                System.out.print(ch);
            }
        }

    }
}
