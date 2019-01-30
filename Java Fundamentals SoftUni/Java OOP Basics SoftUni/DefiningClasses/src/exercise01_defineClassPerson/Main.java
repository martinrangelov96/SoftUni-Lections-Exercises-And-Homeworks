package exercise01_defineClassPerson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfPeople = Integer.parseInt(reader.readLine());

        Map<String, Integer> peopleNameAndAge = new TreeMap<>();

        while (numberOfPeople-- > 0) {
            String line = reader.readLine();
            String[] peopleData = line.split("\\s+");
            String personName = peopleData[0];
            int personAge = Integer.parseInt(peopleData[1]);

            Person person = new Person(personName, personAge);
            peopleNameAndAge.putIfAbsent(person.getName(), person.getAge());
        }

        peopleNameAndAge.entrySet().stream()
                .filter(x -> x.getValue() > 30)
                .forEach(x -> System.out.printf("%s - %d%n", x.getKey(), x.getValue()));

    }
}
