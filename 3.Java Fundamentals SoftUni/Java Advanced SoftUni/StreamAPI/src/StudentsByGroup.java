import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Pair<String, String>>> students = new HashMap<>();

        String line;
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            String firsName = tokens[0];
            String lastName = tokens[1];
            String group = tokens[2];

            Pair<String, String> name = new Pair<>(firsName, lastName);

            List<Pair<String, String>> names = new ArrayList<>();
            if (students.containsKey(group)) {
                names = students.get(group);
            }

            names.add(name);
            students.putIfAbsent(group, names);

        }

        students.entrySet().stream()
                .filter(g -> g.getKey().equals("2"))
                .forEach(g -> g.getValue().stream()
                .sorted(Comparator.comparing(Pair::getKey))
                .forEach(s -> System.out.printf("%s %s%n", s.getKey(), s.getValue())));

    }
}
