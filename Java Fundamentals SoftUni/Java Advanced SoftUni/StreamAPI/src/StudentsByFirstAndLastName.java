import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Pair<String, String>> students = new ArrayList<>();

        String line;
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            String firsName = tokens[0];
            String lastName = tokens[1];

            Pair<String, String> student = new Pair<>(firsName, lastName);

            students.add(student);

        }

        students.stream()
                .filter(s -> s.getValue().compareTo(s.getKey()) > 0)
                .forEach(s -> System.out.println(String.format("%s %s",
                        s.getKey(), s.getValue())));

    }
}
