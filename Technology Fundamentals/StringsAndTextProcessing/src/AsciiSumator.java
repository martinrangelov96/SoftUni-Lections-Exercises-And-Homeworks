import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.next().charAt(0);
        char secondChar = scanner.next().charAt(0);
        String filler = scanner.nextLine();
        String randomString = scanner.nextLine();

        int sum = 0;

        for (int i = 0; i < randomString.length(); i++) {
            if (firstChar < randomString.charAt(i) && randomString.charAt(i) < secondChar) {
                sum += randomString.charAt(i);
            }
        }

        System.out.println(sum);
    }
}
