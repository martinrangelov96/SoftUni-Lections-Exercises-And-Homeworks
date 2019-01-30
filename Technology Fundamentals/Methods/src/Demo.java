import java.util.Scanner;

public class Demo {

    static String repeatString(char toRepeat, int times) {
        String repeatedString = "";
        for (int i = 0; i < times; i++) {
            repeatedString += toRepeat;
        }

        return repeatedString;
    }

    static String repeatOnNewLine(String toRepeat, int times) {
        String repeatedString = "";
        for (int i = 0; i < times; i++) {
            repeatedString += toRepeat + System.lineSeparator();
        }
        return repeatedString;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String innerLineWithSpaces = "*" + repeatString(' ', n - 2) + "*";
        String stars = repeatString('*', n);
        System.out.println(stars);
        System.out.print(repeatOnNewLine(innerLineWithSpaces, n - 2));
        System.out.println(stars);
    }
}
