import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FilterStudentsByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> nameAndPhone = new LinkedHashMap<>();

        String line;
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            String firstName = tokens[0];
            String lastName = tokens[1];
            String phoneNumber = tokens[2];

            nameAndPhone.putIfAbsent(firstName + " " + lastName, phoneNumber);
        }

        nameAndPhone.entrySet().stream()
                .filter(p -> p.getValue().startsWith("02") || p.getValue().startsWith("+3592"))
                .forEach(s -> System.out.println(s.getKey()));

    }
}
