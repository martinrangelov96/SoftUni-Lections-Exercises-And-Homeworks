import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames15 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s|/|\\\\|,|//(|//)");

        Pattern pattern = Pattern.compile("^[A-Za-z][A-Za-z0-9_]{2,24}$");

        int bestSum = 0;
        int maxSum = Integer.MIN_VALUE;
        String bestFirstUsername = "";
        String bestSecondUsername = "";

        ArrayList<String> validUsernames = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            Matcher matcher = pattern.matcher(input[i]);

            if (matcher.find()) {
                validUsernames.add(input[i]);
            }
        }

        for (int j = 0; j < validUsernames.size() - 1 ; j++) {
            bestSum = validUsernames.get(j).length() + validUsernames.get(j + 1).length();

            if (bestSum > maxSum) {
                maxSum = bestSum;
                bestFirstUsername = validUsernames.get(j);
                bestSecondUsername = validUsernames.get(j + 1);
            }

        }

        System.out.println(bestFirstUsername);
        System.out.println(bestSecondUsername);

    }
}