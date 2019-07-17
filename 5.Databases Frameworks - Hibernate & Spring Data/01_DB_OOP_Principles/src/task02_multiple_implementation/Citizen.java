package task02_multiple_implementation;

public class Citizen implements
        Person, Birthable, Identifiable {

    private String name;
    private int age;
    private String birthdate;
    private String id;

    public Citizen(String name, int age, String id, String birthdate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthdate = birthdate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthdate() {
            return this.birthdate;
    }
}
