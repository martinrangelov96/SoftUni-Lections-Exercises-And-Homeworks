package exercise06_birthdayCelebrations;

public class Pet implements Birthable {

    private String name;
    private String birthdayDate;

    public Pet(String name, String birthdayDate) {
        this.name = name;
        this.birthdayDate = birthdayDate;
    }

    @Override
    public void getBirthdayDate(String birthdayDate) {
        if (this.birthdayDate.endsWith(birthdayDate)) {
            System.out.println(this.birthdayDate);
        }
    }
}
