import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String removeWord = scanner.nextLine();
        String text = scanner.nextLine();

        while (text.contains(removeWord)) {
            text = text.replace(removeWord, "");
        }

        System.out.println(text);

    }
}
