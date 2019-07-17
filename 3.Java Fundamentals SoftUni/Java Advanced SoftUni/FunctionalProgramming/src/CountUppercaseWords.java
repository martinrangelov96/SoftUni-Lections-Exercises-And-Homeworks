import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        Predicate<String> testUpperCase = word -> {
            return word.charAt(0) == word.toUpperCase().charAt(0);
        };


        List<String> upperCaseWords = new ArrayList<>();

        for (String word : input) {
            if (testUpperCase.test(word)) {
                upperCaseWords.add(word);
            }
        }

        System.out.println(upperCaseWords.size());
        upperCaseWords.forEach(word -> System.out.println(word));

    }
}
