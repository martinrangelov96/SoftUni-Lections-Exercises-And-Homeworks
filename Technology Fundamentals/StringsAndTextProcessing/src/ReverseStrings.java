import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder reversedInput = new StringBuilder();

        while (!input.equals("end")) {

            for (int i = input.length() - 1 ; i >= 0 ; i--) {
                reversedInput.append(input.charAt(i));
            }

            System.out.println(input + " = " +reversedInput);

            reversedInput = new StringBuilder();

            input = scanner.nextLine();
        }

    }
}
