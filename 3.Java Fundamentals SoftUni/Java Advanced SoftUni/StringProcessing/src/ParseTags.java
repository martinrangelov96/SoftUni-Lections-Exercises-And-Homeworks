import java.util.Scanner;

public class ParseTags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        int startIndex = text.indexOf("<upcase>");

        while(startIndex != -1) {
            int endIndex = text.indexOf("</upcase");
            String value = text.substring(startIndex + 8, endIndex);
            text = text.replaceFirst(value, value.toUpperCase());
            text = text.replaceFirst("<upcase>", "");
            text = text.replaceFirst("</upcase>", "");

            startIndex = text.indexOf("<upcase>");

        }

        System.out.println(text);

    }
}
