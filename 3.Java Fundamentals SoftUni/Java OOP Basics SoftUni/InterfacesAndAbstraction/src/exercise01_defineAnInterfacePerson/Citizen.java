package exercise01_defineAnInterfacePerson;

public class Citizen implements Person {

    private String name;
    private int age;

    protected Citizen(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }
}
