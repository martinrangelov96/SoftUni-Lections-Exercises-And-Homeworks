import java.util.Scanner;

public class EqualWords {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String firstWord = scanner.nextLine();
        String secondWord = scanner.nextLine();

        if (firstWord.equalsIgnoreCase(secondWord)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }

}
