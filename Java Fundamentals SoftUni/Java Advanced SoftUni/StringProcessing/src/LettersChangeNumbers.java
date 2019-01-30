import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        String patternRegex = "([A-za-z])(\\d+)([A-Za-z])";

        Pattern pattern = Pattern.compile(patternRegex);

        String letterBeforeNumber;
        String number = "";
        String letterAfterNumber = "";
        double singleInputSum = 0.0;
        double allInputsSum = 0.0;

        for (int i = 0; i < input.length; i++) {
            Matcher matcher = pattern.matcher(input[i]);

            if (matcher.find()) {
                letterBeforeNumber = matcher.group(1);
                number = matcher.group(2);
                letterAfterNumber = matcher.group(3);

                singleInputSum = Integer.parseInt(number);

                if (Character.isUpperCase(letterBeforeNumber.charAt(0))) {
                    singleInputSum /= letterBeforeNumber.charAt(0) - 64;
                } else {
                    singleInputSum *= letterBeforeNumber.charAt(0) - 96;
                }

                if (Character.isUpperCase(letterAfterNumber.charAt(0))) {
                    singleInputSum -= letterAfterNumber.charAt(0) - 64;
                } else {
                    singleInputSum += letterAfterNumber.charAt(0) - 96;
                }

                allInputsSum += singleInputSum;

            }
        }

        System.out.printf("%.2f", allInputsSum);

    }
}
