import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] bannedWords = reader.readLine().split(", ");
        String input = reader.readLine();

        for (String bannedWord : bannedWords) {
            if (input.contains(bannedWord)) {
                input = input.replaceAll(bannedWord, new String(new char[bannedWord.length()]).replace('\0','*'));
            }
        }

        System.out.println(input);

    }
}
