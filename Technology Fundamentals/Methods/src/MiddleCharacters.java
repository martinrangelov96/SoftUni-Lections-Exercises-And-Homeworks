import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String result = middleCharacters(input);

        System.out.println(result);

    }

    public static String middleCharacters(String input) {

        String result = "";

        int middleIndex = input.length() / 2;

        if (input.length() % 2 == 1) {
            result += input.charAt(middleIndex);
        } else {
            result += input.charAt(middleIndex - 1);
            result += input.charAt(middleIndex);
        }

        return result;

    }

}
