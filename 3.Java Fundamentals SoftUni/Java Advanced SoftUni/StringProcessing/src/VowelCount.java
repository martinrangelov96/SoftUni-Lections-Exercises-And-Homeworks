import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("[AEIOUYyaeiou]");

        Matcher matcher = pattern.matcher(input);

        int count = 0;

        while (matcher.find()) {
            count++;
        }

        System.out.println("Vowels: " +count);

    }
}
