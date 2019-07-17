package exercise06_strategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> treeSetByName =
                new TreeSet<>(new ComparatorByPersonLengthThenFirstNameLetter());

        Set<Person> treeSetByAge =
                new TreeSet<>(new ComparatorByPersonAge());

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));

            treeSetByName.add(person);
            treeSetByAge.add(person);
        }

        treeSetByName.forEach(System.out::println);
        treeSetByAge.forEach(System.out::println);

    }
}
