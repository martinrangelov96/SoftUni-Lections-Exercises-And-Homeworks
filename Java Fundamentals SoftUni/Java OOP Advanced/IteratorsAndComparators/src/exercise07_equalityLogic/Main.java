package exercise07_equalityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> personTreeSet = new TreeSet<>();
        Set<Person> personHashSet = new HashSet<>();

        int numberOfLines = Integer.parseInt(reader.readLine());

        while (numberOfLines-- > 0) {
            String[] input = reader.readLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person(name, age);
            personTreeSet.add(person);
            personHashSet.add(person);

        }

        System.out.println(personTreeSet.size());
        System.out.println(personHashSet.size());

    }
}
