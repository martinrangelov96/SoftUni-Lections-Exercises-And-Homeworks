import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        LinkedHashMap<Character, Integer> charByOccurances = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            if (letter != ' ') {
                if (!charByOccurances.containsKey(letter)) {
                    charByOccurances.put(letter, 1);
                } else {
                    charByOccurances.put(letter, charByOccurances.get(letter) + 1);
                }
            }
        }

        for (Character letter : charByOccurances.keySet()) {
            System.out.printf("%c -> %d%n", letter, charByOccurances.get(letter));
        }
    }
}
