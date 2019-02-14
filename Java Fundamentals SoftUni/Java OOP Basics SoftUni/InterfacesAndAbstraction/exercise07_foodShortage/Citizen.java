package exercise07_foodShortage;

public class Citizen implements Identifiable, Birthable, Buyer {

    private String name;
    private int age;
    private String id;
    private String birthdayDate;
    private int food;

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

    @Override
    public Integer getFood() {
        return this.food;
    }

    @Override
    public void buyFood(String buyerName) {
        if (this.name.equals(buyerName)) {
            this.food += 10;
        }
    }

}
