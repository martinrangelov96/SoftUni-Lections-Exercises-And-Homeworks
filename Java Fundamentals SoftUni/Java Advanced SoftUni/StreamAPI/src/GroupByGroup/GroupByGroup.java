package GroupByGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        String line;
        while (true) {

            if ("END".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            String firstName = tokens[0];
            String lastName = tokens[1];
            int group = Integer.parseInt(tokens[2]);

            String fulLName = firstName + " " + lastName;
            Person person = new Person(fulLName, group);

            people.add(person);

        }

        Map<Integer, List<Person>> peopleByGroup = people.stream()
                .collect(Collectors.groupingBy(Person::getGroup));

        peopleByGroup.forEach((key, value) ->
                System.out.println
                        (String.format("%d - %s", key, String.join(", ", value.stream().map(p -> p.getName())
                                .collect(Collectors.toList())))));

    }

}

class Person {
    private String name;
    private int group;

    public Person(String name, int group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public int getGroup() {
        return group;
    }
}
