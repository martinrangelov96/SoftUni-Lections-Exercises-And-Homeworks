import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String word = reader.readLine();
        String[] input = reader.readLine().split("(?<=[.!?])");

        Pattern pattern = Pattern.compile("^[^.!?]*[.!?]");

        for (int i = 0; i < input.length; i++) {
            Matcher matcher = pattern.matcher(input[i]);

            if (matcher.find() && input[i].contains(" " +word + " ")) {
                System.out.println(input[i].trim());
            }
        }

    }
}
