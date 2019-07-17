package exercise06_strategyPattern;

import java.util.Comparator;

public class ComparatorByPersonAge implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getAge() - o2.getAge() == 0) {
            return 0;
        }
        return o1.getAge() - o2.getAge();
    }
}
