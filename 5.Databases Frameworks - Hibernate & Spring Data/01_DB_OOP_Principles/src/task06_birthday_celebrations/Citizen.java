package task06_birthday_celebrations;

public class Citizen extends BaseBirthday implements Identifiable, Birthdayable {

    private int age;
    private String id;

    public Citizen(String name, int age, String id, String birthdate) {
        super(name, birthdate);
        this.age = age;
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
