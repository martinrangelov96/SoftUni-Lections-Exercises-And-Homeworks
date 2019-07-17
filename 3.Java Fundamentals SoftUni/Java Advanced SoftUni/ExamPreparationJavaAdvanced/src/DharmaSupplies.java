import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DharmaSupplies {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfLines = 0;

        String patternRegex = "\\[.*?]";

        StringBuilder lines = new StringBuilder();

        String line;
        while (true) {
            if ("Collect".equals(line = reader.readLine())) {
                break;
            }

            lines.append(line).append(System.lineSeparator());
            countOfLines++;

        }

        String linesToString = lines.toString();

        Pattern patternCrateRegex = Pattern.compile("\\[.*?]");
        Matcher matcher = patternCrateRegex.matcher(lines.toString());

        List<String> crates = new ArrayList<>();

        int countOfCrates = 0;

        while (matcher.find()) {
            countOfCrates++;
        }

        int n = countOfCrates / countOfLines;

        Pattern validCrateRegex = Pattern.compile("\\[(#(\\d{" + n + "}|[a-z]{" + n + "}))([A-Za-z0-9\\s]+)(\\1)]");
        Matcher matcher1 = validCrateRegex.matcher(linesToString);

        int countValidCrates = 0;
        int amountOfFood = 0;
        int amountOfDrink = 0;

        while (matcher1.find()) {
            String crate = matcher1.group();
            String supplyTag = matcher1.group(2);
            String body = matcher1.group(3);

            if (Character.isDigit(supplyTag.charAt(0))) {
                amountOfFood += computeFoodAmount(supplyTag, body);
            } else {
                amountOfDrink += computeDrinkAmount(supplyTag, body);
            }

            countValidCrates++;
            String debug = "";
        }

        if (countValidCrates == 0) {
            System.out.println("No supplies found!");
        } else {
            StringBuilder result = new StringBuilder(
                    String.format("Number of supply crates: %d", countValidCrates))
                    .append(System.lineSeparator())
                    .append(String.format("Amount of food collected: %d", amountOfFood))
                    .append(System.lineSeparator())
                    .append(String.format("Amount of drinks collected: %d", amountOfDrink));

            System.out.println(result.toString());
        }

    }

    private static int computeDrinkAmount(String supplyTag, String body) {
        int sumOfCharactersBody = Arrays.stream(body.split("")).mapToInt(s -> s.charAt(0)).sum();

        //valid second version
//        int sumOfUniqueCharactersBody = body.chars().sum();

        int sumOfCharactersTag = Arrays.stream(supplyTag.split("")).mapToInt(s -> s.charAt(0)).sum();

        return sumOfCharactersBody * sumOfCharactersTag;
    }

    private static int computeFoodAmount(String supplyTag, String body) {
        int sumOfUniqueCharacters = Arrays.stream(body.split("")).distinct().mapToInt(s -> s.charAt(0)).sum();
        int lengthOfSupplyTag = supplyTag.length();

        return sumOfUniqueCharacters * lengthOfSupplyTag;

    }
}
