import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> uniqueUsernames = new LinkedHashSet<>();

        int numberOfNames = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfNames; i++) {
            String name = scanner.nextLine();
            uniqueUsernames.add(name);
        }

        for (String uniqueUsername : uniqueUsernames) {
            System.out.println(uniqueUsername);
        }

    }
}
