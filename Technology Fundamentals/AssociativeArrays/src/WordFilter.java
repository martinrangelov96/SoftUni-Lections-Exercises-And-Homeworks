import java.util.Arrays;
import java.util.Scanner;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] fruits = Arrays.stream(scanner.nextLine().split(" "))
                .filter(e -> e.length() % 2 ==0)
                .toArray(String[]::new);

        for (String fruit : fruits) {
            System.out.println(fruit);
        }

    }
}
