import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("[ ,.?!]+");

        TreeSet<String> palindromes = new TreeSet<>();

        for (int i = 0; i < input.length; i++) {
            if (isItPalindrome(input[i])) {
                palindromes.add(input[i]);
            }
        }

        String result = palindromes.toString();
        System.out.println(result);

    }

    private static boolean isItPalindrome(String word) {
        return word.equals(new StringBuilder(word).reverse().toString());
    }
}
