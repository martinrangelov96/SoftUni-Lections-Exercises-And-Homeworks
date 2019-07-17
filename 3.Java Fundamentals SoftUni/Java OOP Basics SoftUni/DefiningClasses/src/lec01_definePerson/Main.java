package lec01_definePerson;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Person p1 = new Person("asd", 2);
        Person p2 = new Person("asd", 2);
        Person p3 = new Person("asd", 2);

        System.out.println(Person.personCount);

    }
}
