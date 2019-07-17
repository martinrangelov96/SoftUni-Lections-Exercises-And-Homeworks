package exercise06_birthdayCelebrations;

public class Citizen implements Identifiable, Birthable {

    private String name;
    private int age;
    private String id;
    private String birthdayDate;

    public Citizen(String name, int age, String id, String birthdayDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthdayDate = birthdayDate;
    }

    @Override
    public void getId(String id) {
        if (this.id.endsWith(id)) {
            System.out.println(this.id);
        }
    }

    @Override
    public void getBirthdayDate(String birthdayDate) {
        if (this.birthdayDate.endsWith(birthdayDate)) {
            System.out.println(this.birthdayDate);
        }
    }
}
