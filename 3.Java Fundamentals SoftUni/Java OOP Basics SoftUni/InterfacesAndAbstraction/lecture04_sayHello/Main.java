package lecture04_sayHello;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>() {{
            add(new Bulgarian("Strahil"));
            add(new European("dasa"));
            add(new Chinese("vingchung"));
        }};

        for (Person person : people) {
            printPerson(person);
        }

    }

    private static void printPerson(Person person) {
        System.out.println(person.sayHello());
    }
}
