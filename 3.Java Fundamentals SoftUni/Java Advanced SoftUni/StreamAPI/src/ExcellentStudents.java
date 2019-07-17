import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExcellentStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> studentAndResults = new LinkedHashMap<>();

        String line;
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+", 3);

            String firstName = tokens[0];
            String lastName = tokens[1];
            String results = tokens[2];

            studentAndResults.putIfAbsent(firstName + " " + lastName, results);

        }

        studentAndResults.entrySet().stream()
                .filter(s -> s.getValue().contains("6"))
                .forEach(s -> System.out.println(s.getKey()));

    }
}
