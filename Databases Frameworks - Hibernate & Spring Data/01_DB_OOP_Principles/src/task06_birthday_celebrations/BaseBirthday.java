package task06_birthday_celebrations;

public abstract class BaseBirthday implements Birthdayable {

    private String name;
    private String birthdate;

    protected BaseBirthday(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getBirthdate() {
        return this.birthdate;
    }
}
