package exercise07_equalityLogic;

import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    //compare TreeSet
    @Override
    public int compareTo(Person otherPerson) {
        int comparePeople = this.getName().compareTo(otherPerson.getName());
        if (comparePeople == 0) {
            comparePeople = Integer.compare(this.getAge(), otherPerson.getAge());
        }
        return comparePeople;
    }

    //Compare HashSet
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Person)){
            return false;
        }
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }

    ////Compare HashSet
    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

}
