package exercise07_foodShortage;

public class Rebel implements Buyer{

    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    @Override
    public void buyFood(String buyerName) {
        if (this.name.equals(buyerName)) {
            food +=5;
        }
    }

    @Override
    public Integer getFood() {
        return this.food;
    }
}
