package ex02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OpinionPoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);

            people.add(person);

        }

        people = people.stream().filter(person -> person.getAge() > 30)
                .collect(Collectors.toCollection(ArrayList::new));

        people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(p -> System.out.println(p.toString()));

    }
}

