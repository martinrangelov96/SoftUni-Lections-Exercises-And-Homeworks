import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractTags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("<.+?>");

        String line = scanner.nextLine();

        while(!"END".equals(line)) {
            Matcher matcher = pattern.matcher(line);

            while(matcher.find()) {
                System.out.println(matcher.group());
            }

            line = scanner.nextLine();
        }

    }
}
