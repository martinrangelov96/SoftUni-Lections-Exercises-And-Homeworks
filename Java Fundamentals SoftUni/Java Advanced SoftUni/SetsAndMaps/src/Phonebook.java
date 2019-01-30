import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new LinkedHashMap<>();

        while(true) {
            String[] input = scanner.nextLine().split("-");
            String name = input[0];
            if ("search".equals(name)) {
                break;
            }
            String phoneNumber = input[1];

            phonebook.put(name, phoneNumber);
        }

        String input = scanner.nextLine();
        while (!"stop".equals(input)) {

            if (phonebook.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }

            input = scanner.nextLine();
        }
    }
}
