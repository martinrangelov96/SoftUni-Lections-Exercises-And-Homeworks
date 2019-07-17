import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        int counter = Integer.parseInt(scanner.nextLine());

        System.out.println(repeatString(word, counter));

    }

    private static String repeatString(String word, int counter) {
        String result = "";
        for (int i = 0; i < counter; i++) {
            result += word;
        }
        return result;
    }

}

