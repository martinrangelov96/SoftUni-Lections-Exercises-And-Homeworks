import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("^[\\w-]{3,16}$");

        String line = scanner.nextLine();

        List<String> list = new ArrayList<>();

        while (!"END".equals(line)) {
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                list.add("valid");
            } else {
                list.add("invalid");
            }

            line = scanner.nextLine();
        }

        if (list.contains("valid")) {
            for (String s : list) {
                System.out.println(s);
            }
        }

    }
}
