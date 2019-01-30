import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        Pattern pattern = Pattern.compile("\\+359([- ])2\\1\\d{3}\\1\\d{4}$");

        while (true) {
            if ("end".equals(input = reader.readLine())) {
                break;
            }

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                System.out.println(input);
            }
        }

    }
}
