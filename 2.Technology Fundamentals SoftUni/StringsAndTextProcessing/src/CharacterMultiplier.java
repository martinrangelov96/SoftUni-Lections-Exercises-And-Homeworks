import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int result = multiplyCharacters(input[0],input[1]);

        System.out.println(result);

    }

    private static int multiplyCharacters(String first, String second) {
        int result = 0;

        int length = Math.min(first.length(),second.length());

        for (int i = 0; i < length; i++) {
            result += first.charAt(i) * second.charAt(i);
        }

        if (first.length() > second.length()) {
            for (int i = length; i < first.length(); i++) {
                result += first.charAt(i);
            }
        } else {
            for (int i = length; i < second.length(); i++) {
                result += second.charAt(i);
            }
        }

        return result;
    }
}
