import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> nameAndEmail = new LinkedHashMap<>();

        while (true) {

            String personName = scanner.nextLine();
            if ("stop".equals(personName)) {
                break;
            }
            String personEmail = scanner.nextLine();
            String[] emailAndDomain = personEmail.split("\\.");
            String domain = emailAndDomain[1];

            if (!nameAndEmail.containsKey(personName) && !"us".equals(domain) && !"uk".equals(domain) && !"com".equals(domain)) {
                nameAndEmail.put(personName, personEmail);
            }
        }

        for (Map.Entry<String, String> entry : nameAndEmail.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }

    }
}
